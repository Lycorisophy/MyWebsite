create table article
(
    id          bigint auto_increment primary key,
    author_id          bigint not null comment '作者id',
    title varchar(255) not null comment '文章标题',
    brief varchar(255) not null comment '文章摘要',
    tag varchar(64) not null comment '文章标签',
    content longtext not null comment '文章内容',
    editor_id bigint null comment '文章上一次编辑者id',
    create_time datetime      not null comment '创建时间',
    update_time datetime      not null comment '更新时间',
    unique (title)
) engine=innodb auto_increment=1 comment '文章列表' charset = utf8;