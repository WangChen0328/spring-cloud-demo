package cn.test;

import org.springframework.context.annotation.Bean;

/**
 * @author wangchen
 * @version 1.0
 * @date 2022/5/2 8:20
 */
public class UserConfiguration {

    @Bean
    public UserBean initUserBean() {
        UserBean userBean = new UserBean();
        userBean.setAge(18);
        userBean.setName("zhangsan");
        return userBean;
    }
}
