package cn.lysoy.myblog.config;

import cn.lysoy.myblog.interceptor.AdminInterceptor;
import cn.lysoy.myblog.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 *
 * @Description:拦截器配置
 * @author: LySoY
 * @date: 2022/2/16
 */
@Configuration
public class AdminConfig implements WebMvcConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new AdminInterceptor());
        //所有路径都被拦截
        registration.addPathPatterns("/add_user.html", "/del_user.html");
        registration.excludePathPatterns(                         //添加不拦截路径
                "/static/*.html",            //html静态资源
                "/static/*.js",              //js静态资源
                "/static/*.css",             //css静态资源
                "/static/*.images"
        );
    }
}
