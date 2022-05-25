package cn.wangchen.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * spring
 * @author wangchen
 * @version 1.0
 * @date 2022/5/14 20:58
 */
@Configuration
public class KeyResolverConfiguration {

    /**
     * 路径路由，不在这个路径下不进行，限流
     * @return
     */
    @Primary
    @Bean("pathKeyResolver")
    public KeyResolver initKeyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest().getPath().toString());
            }
        };
    }

    /**
     * 参数过滤器，如果在当前路径下，没有userId参数，则报500，没有参数
     * @return
     */
    @Bean("userKeyResolver")
    public KeyResolver initKeyResolver1() {
        return exchange -> {
            return Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
        };
    }
}
