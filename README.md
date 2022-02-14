# MyBlog

#### 项目展示：[https://lysoy.cn](https://lysoy.cn)
#### remote repository：[https://github.com/Lycorisophy/MyWebsite](https://github.com/Lycorisophy/MyWebsite)

#### 本地开发
git clone项目到本地，修改配置文件[resources/application*.*]中的数据库连接信息，导入SQl/*.SQL文件生成所有表

#### 安装部署
可以使用docker方式部署，也可支持-jar方式，服务器可以用阿里云

## 项目设计

### 功能需求
##### 主页
- 博客汇总，以列表形式展示文章，并附上文章作者、发布日期、分类情况以及文章简要

- 点击文章标题进入文章详情页

- 能够以分类形式查看文章

- 个人介绍、联系方式

- 置顶文章
 

##### 后台管理
- 发布文章（用户权限1）
  1.使用markdown编辑器，支持插入代码，插入图片等功能

- 修改文章（用户权限2）
  1.分页展示文章信息
  2.改变文章基本信息
  3.可对文章进行编辑
  4.可以删除文章
  
- 用户管理（用户权限3）
  1.可以添加权限1-3用户
  2.可以删除权限1-2用户
  3.可以修改权限1-2用户信息
  4.可以修改用户自身信息

### 页面设计

##### 首页
![]()
<br>
##### 文章编辑
![]()
<br>
##### 后台管理
![]()
<br>
##### 个人中心
![]()


### 总体设计
- **本项目用到的技术和框架**<br>
  1.项目构建：Maven<br>
  2.web框架：Springboot<br>
  3.数据库ORM：Mybatis<br>
  4.数据库连接池： Druid<br>
  5.分页插件：PageHelper<br>
  6.数据库：MySql<br>
  7.缓存：Redis<br>
  8.前端模板：Thymeleaf<br>
  
- **环境**

|  工具 | 名称
| ------------ | ------------
| 开发工具  | IDEA
|  语言 | JDK11
|  前端 | Sparkle软件
| 数据库  | Mysql8.0.26
| 项目框架  | SSM
| ORM  | Mybatis
| 安全框架  | SpringSecurity
| 缓存  | Redis
| 项目构建  | Maven
| 运行环境  | 阿里云

### 结构设计

![]()


### 业务设计
#### 发布文章流程

![]()

#### 修改文章流程

![]()

#### 登录流程

![]()

#### 添加用户

![]()

### 数据库设计

#### 数据字典

###### 用户表：user
| 名称  | 类型  |  长度 |  主键 | 非空  | 描述
| ------------ | ------------ | ------------ | ------------ | ------------ | ------------
| id  | bigint unsigned  |  11 |  true |  true | 主键，自增，步长为 1
| username  | varchar  | 64  |  false | true  |  用户名,唯一
| password  |  varchar |  64 |  false | true  | 密码
| role  |  int |   |  false | true  | 用户权限
| brief  |  varchar | 255  | false  | false  |  个人简介
| last_login_time  | datatime  |  8bytes |  false | false  |  最近登录时间
| create_time  |  datetime | 8bytes  | false  | true  |  创建时间
| update_time  |  datetime | 8bytes  | false  | true  |  数据更新时间

###### 文章表：article
| 名称  | 类型  |  长度 |  主键 | 非空  | 描述
| ------------ | ------------ | ------------ | ------------ | ------------ | ------------
| id  | bigint unsigned  |  11 |  true |  true | 主键，自增，步长为 1
| author_id  | bigint unsigned  | 11  |  false | true  |  作者
| title  | varchar  | 255  | false  |  true | 文章标题,唯一
| brief  | varchar  |  255 |  false | true  |  文章摘要
| tag  |  varchar | 64  |  false | true  | 文章标签
| content  | longtext  | 0  |  false | true  | 文章内容
| editor_id  |  bigint unsigned | false  | false  | true  |  上一次编辑者
| create_time  |  datetime | 8bytes  | false  | true  |  创建时间
| update_time  |  datetime | 8bytes  | false  | true  |  数据更新时间