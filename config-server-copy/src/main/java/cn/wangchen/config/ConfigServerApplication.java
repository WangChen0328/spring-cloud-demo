package cn.wangchen.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * github
 *  http://127.0.0.1:10001/master/product-dev.yml
 *
 * 配置文件前必须加，分支。
 *
 * @author wangchen
 * @version 1.0
 * @date 2022/5/24 14:38
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
