package cn.lysoy.myblog.util;

import cn.lysoy.myblog.model.Markdown;
import com.google.common.base.Joiner;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LySoY
 * @Date 2022/2/13
 * Describe: Markdown工具
 */
public class MarkdownUtil {
    private static final Integer maxLength = 200;
    private static String MD_CSS = null;
    /**
     * @author LySoY
     * @param htmlArticleComment markdown文章
     * @Date 2022/2/13
     * @return 摘要
     * Describe: html截取文章生成摘要
     */
    public String htmlToBrief(String htmlArticleComment){

        String regex = "\\s+";
        String str = htmlArticleComment.trim();
        //去掉所有空格
        String articleTabloid = str.replaceAll(regex,StringUtil.BLANK);

        int beginIndex = articleTabloid.indexOf("<");
        int endIndex = articleTabloid.indexOf(">");
        String myArticleTabloid = "";
        String nowStr = "";
        while (beginIndex != -1){
            nowStr = articleTabloid.substring(0, beginIndex);
            if(nowStr.length() > maxLength){
                nowStr = nowStr.substring(0, maxLength);
                myArticleTabloid += nowStr;
            } else {
                myArticleTabloid += nowStr;
            }

            articleTabloid = articleTabloid.substring(endIndex + 1);
            beginIndex = articleTabloid.indexOf("<");
            if(myArticleTabloid.length() < maxLength){
                //过滤掉<pre>标签中的代码块
                if(articleTabloid.length() > 4){
                    if(articleTabloid.charAt(beginIndex) == '<'
                            && articleTabloid.charAt(beginIndex+1) == 'p'
                            && articleTabloid.charAt(beginIndex+2) == 'r'
                            && articleTabloid.charAt(beginIndex+3) == 'e' ){
                        endIndex = articleTabloid.indexOf("</pre>");
                        endIndex = endIndex + 5;
                    } else {
                        endIndex = articleTabloid.indexOf(">");
                    }
                } else {
                    endIndex = articleTabloid.indexOf(">");
                }
            } else {
                break;
            }

        }

        if(myArticleTabloid.length() > maxLength){
            myArticleTabloid = myArticleTabloid.substring(0, maxLength);
        }

        return myArticleTabloid;
    }
    
    static {
        try {
            MD_CSS = Files.readString(Paths.get("md/huimarkdown.css"));
            MD_CSS = "<style type=\"text/css\">\n" + MD_CSS + "\n</style>\n";
        } catch (Exception e) {
            MD_CSS = "";
        }
    }


    /**
     * 将本地的markdown文件，转为html文档输出
     *
     * @param path 相对地址or绝对地址 ("/" 开头)
     * @return
     * @throws IOException
     */
    public static Markdown ofFile(String path) throws IOException {
        return ofStream(FileUtil.getStreamByFileName(path));
    }


    /**
     * 将网络的markdown文件，转为html文档输出
     *
     * @param url http开头的url格式
     * @return
     * @throws IOException
     */
    public static Markdown ofUrl(String url) throws IOException {
        return ofStream(FileUtil.getStreamByFileName(url));
    }


    /**
     * 将流转为html文档输出
     *
     * @param stream
     * @return
     */
    public static Markdown ofStream(InputStream stream) {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(stream, Charset.forName("UTF-8")));
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        String content = Joiner.on("\n").join(lines);
        return ofContent(content);
    }


    /**
     * 直接将markdown语义的文本转为html格式输出
     *
     * @param content markdown语义文本
     * @return
     */
    public static Markdown ofContent(String content) {
        String html = markdownToHtml(content);
        Markdown entity = new Markdown();
        entity.setCss(MD_CSS);
        entity.setHtml(html);
        entity.addDivStyle("class", "markdown-body ");
        return entity;
    }


    /**
     * markdown to image
     *
     * @param content markdown contents
     * @return parse html contents
     */
    public static String markdownToHtml(String content) {
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);

        // enable table parse!
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));


        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(content);
        return renderer.render(document);
    }
}
