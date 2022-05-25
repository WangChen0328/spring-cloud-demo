package cn.order;

import cn.order.controller.ExceptionUtils;
import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangchen
 * @version 1.0
 * @date 2022/5/2 8:06
 */
@EnableDiscoveryClient
@SpringBootApplication
//@EnableCircuitBreaker
//@EnableHystrixDashboard
public class OrderApplication {

    @SentinelRestTemplate(fallbackClass = ExceptionUtils.class, fallback = "handlerFallback",
        blockHandlerClass = ExceptionUtils.class, blockHandler = "handlerBlock")
    @LoadBalanced
    @Bean
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
