package cn.wangchen.secutiry.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wangchen
 * @version 1.0
 * @date 2022/5/16 13:53
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        /**
         * security 异常都已 login-view 开头
         * .formLogin()
         *    .loginPage("/login-view")
         */
        registry.addViewController("/login-view").setViewName("login");
    }
}
