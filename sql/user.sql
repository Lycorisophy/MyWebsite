create table user
(
    id          bigint auto_increment primary key,
    username        varchar(64)  not null comment '用户名',
    password        varchar(64)  not null comment '密码',
    role int default 1 not null comment '用户权限',
    brief varchar(255) null comment '用户简介',
    last_login_time datetime null comment '创建时间',
    create_time datetime      not null comment '创建时间',
    update_time datetime      not null comment '更新时间',
    unique (username)
) engine=innodb auto_increment=1 comment '后台用户角色表' charset = utf8;