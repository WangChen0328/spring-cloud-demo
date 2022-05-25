package cn.test;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wangchen
 * @version 1.0
 * @date 2022/5/2 8:21
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import(UserImportSelector.class)
public @interface EnableUserBean {
}
