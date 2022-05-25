package order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangchen
 * @version 1.0
 * @date 2022/5/2 8:06
 */
@SpringBootApplication
@EnableFeignClients
/**
 * 监控必须注解，如果不监控则不用，feign自带
 */
//@EnableCircuitBreaker
//@EnableHystrixDashboard
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
