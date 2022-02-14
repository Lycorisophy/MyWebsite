package cn.lysoy.myblog.util;

import org.junit.jupiter.api.Test;

public class MarkdownTest {
    @Test
    public static void main(String[] args) {
        String s = MarkdownUtil.markdownToHtml("# MyBlog\n" +
                "\n" +
                "#### 项目展示：[https://lysoy.cn](https://lysoy.cn)\n" +
                "#### remote repository：[https://github.com/Lycorisophy/MyBlog](https://github.com/Lycorisophy/MyBlog)\n" +
                "\n" +
                "#### 本地开发\n" +
                "git clone项目到本地，修改配置文件[resources/application*.*]中的数据库连接信息，导入SQl/*.SQL文件生成所有表\n" +
                "\n" +
                "#### 安装部署\n" +
                "可以使用docker方式部署，也可支持-jar方式，服务器可以用阿里云\n" +
                "\n" +
                "## 项目设计\n" +
                "\n" +
                "### 功能需求\n" +
                "##### 主页\n" +
                "- 博客汇总，以列表形式展示文章，并附上文章作者、发布日期、分类情况以及文章简要\n" +
                "\n" +
                "- 点击文章标题进入文章详情页\n" +
                "\n" +
                "- 能够以分类形式查看文章\n" +
                "\n" +
                "- 个人介绍、联系方式\n" +
                "\n" +
                "- 置顶文章\n" +
                " \n" +
                "\n" +
                "##### 后台管理\n" +
                "- 发布文章（用户权限1）\n" +
                "  1.使用markdown编辑器，支持插入代码，插入图片等功能\n" +
                "\n" +
                "- 修改文章（用户权限2）\n" +
                "  1.分页展示文章信息\n" +
                "  2.改变文章基本信息\n" +
                "  3.可对文章进行编辑\n" +
                "  4.可以删除文章\n" +
                "  \n" +
                "- 用户管理（用户权限3）\n" +
                "  1.可以添加权限1-3用户\n" +
                "  2.可以删除权限1-2用户\n" +
                "  3.可以修改权限1-2用户信息\n" +
                "  4.可以修改用户自身信息\n" +
                "\n" +
                "### 页面设计\n" +
                "\n" +
                "##### 首页\n" +
                "![]()\n" +
                "<br>\n" +
                "##### 文章编辑\n" +
                "![]()\n" +
                "<br>\n" +
                "##### 后台管理\n" +
                "![]()\n" +
                "<br>\n" +
                "##### 个人中心\n" +
                "![]()\n" +
                "\n" +
                "\n" +
                "### 总体设计\n" +
                "- **本项目用到的技术和框架**<br>\n" +
                "  1.项目构建：Maven<br>\n" +
                "  2.web框架：Springboot<br>\n" +
                "  3.数据库ORM：Mybatis<br>\n" +
                "  4.数据库连接池： Druid<br>\n" +
                "  5.分页插件：PageHelper<br>\n" +
                "  6.数据库：MySql<br>\n" +
                "  7.缓存：Redis<br>\n" +
                "  8.前端模板：Thymeleaf<br>\n" +
                "  \n" +
                "- **环境**\n" +
                "\n" +
                "|  工具 | 名称\n" +
                "| ------------ | ------------\n" +
                "| 开发工具  | IDEA\n" +
                "|  语言 | JDK11\n" +
                "|  前端 | Sparkle软件\n" +
                "| 数据库  | Mysql8.0.26\n" +
                "| 项目框架  | SSM\n" +
                "| ORM  | Mybatis\n" +
                "| 安全框架  | SpringSecurity\n" +
                "| 缓存  | Redis\n" +
                "| 项目构建  | Maven\n" +
                "| 运行环境  | 阿里云\n" +
                "\n" +
                "### 结构设计\n" +
                "\n" +
                "![]()\n" +
                "\n" +
                "\n" +
                "### 业务设计\n" +
                "#### 发布文章流程\n" +
                "\n" +
                "![]()\n" +
                "\n" +
                "#### 修改文章流程\n" +
                "\n" +
                "![]()\n" +
                "\n" +
                "#### 登录流程\n" +
                "\n" +
                "![]()\n" +
                "\n" +
                "#### 添加用户\n" +
                "\n" +
                "![]()\n" +
                "\n" +
                "### 数据库设计\n" +
                "\n" +
                "#### 数据字典\n" +
                "\n" +
                "###### 用户表：user\n" +
                "| 名称  | 类型  |  长度 |  主键 | 非空  | 描述\n" +
                "| ------------ | ------------ | ------------ | ------------ | ------------ | ------------\n" +
                "| id  | bigint unsigned  |  11 |  true |  true | 主键，自增，步长为 1\n" +
                "| username  | varchar  | 64  |  false | true  |  用户名,唯一\n" +
                "| password  |  varchar |  64 |  false | true  | 密码\n" +
                "| role  |  int |   |  false | true  | 用户权限\n" +
                "| brief  |  varchar | 255  | false  | false  |  个人简介\n" +
                "| last_login_time  | datatime  |  8bytes |  false | false  |  最近登录时间\n" +
                "| create_time  |  datetime | 8bytes  | false  | true  |  创建时间\n" +
                "| update_time  |  datetime | 8bytes  | false  | true  |  数据更新时间\n" +
                "\n" +
                "###### 文章表：article\n" +
                "| 名称  | 类型  |  长度 |  主键 | 非空  | 描述\n" +
                "| ------------ | ------------ | ------------ | ------------ | ------------ | ------------\n" +
                "| id  | bigint unsigned  |  11 |  true |  true | 主键，自增，步长为 1\n" +
                "| author_id  | bigint unsigned  | 11  |  false | true  |  作者\n" +
                "| title  | varchar  | 255  | false  |  true | 文章标题,唯一\n" +
                "| brief  | varchar  |  255 |  false | true  |  文章摘要\n" +
                "| tag  |  varchar | 64  |  false | true  | 文章标签\n" +
                "| content  | longtext  | 0  |  false | true  | 文章内容\n" +
                "| editor_id  |  bigint unsigned | false  | false  | true  |  上一次编辑者\n" +
                "| create_time  |  datetime | 8bytes  | false  | true  |  创建时间\n" +
                "| update_time  |  datetime | 8bytes  | false  | true  |  数据更新时间");
        System.out.println(s);
    }
}
