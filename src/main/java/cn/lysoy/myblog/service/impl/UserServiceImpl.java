package cn.lysoy.myblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.lysoy.myblog.entity.User;
import cn.lysoy.myblog.service.UserService;
import cn.lysoy.myblog.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author lysoy
* @description 针对表【user(后台用户角色表)】的数据库操作Service实现
* @createDate 2022-02-13 20:35:03
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




