package cn.test;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangchen
 * @version 1.0
 * @date 2022/5/2 8:20
 */
@EnableUserBean
public class TestApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
        UserBean bean = applicationContext.getBean(UserBean.class);
        System.out.println(bean.getName());
    }
}
