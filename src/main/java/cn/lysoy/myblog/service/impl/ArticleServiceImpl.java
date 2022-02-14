package cn.lysoy.myblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.lysoy.myblog.entity.Article;
import cn.lysoy.myblog.service.ArticleService;
import cn.lysoy.myblog.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author lysoy
* @description 针对表【article(文章列表)】的数据库操作Service实现
* @createDate 2022-02-13 20:35:03
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

}




