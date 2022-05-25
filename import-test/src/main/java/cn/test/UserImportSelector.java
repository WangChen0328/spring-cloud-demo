package cn.test;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author wangchen
 * @version 1.0
 * @date 2022/5/2 8:21
 */
public class UserImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        /**
         * 可以注册多个configuration
         */
        return new String[]{UserConfiguration.class.getName()};
    }
}
