package order.feign;

import order.po.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangchen
 * @version 1.0
 * @date 2022/5/5 19:49
 */
@FeignClient(name = "service-product", fallback = ProductFeignClientFallback.class)//使用服务提供端，注册的服务名
public interface ProductFeignClient {
    /**
     * 服务端，接口
     * 底层使用jdk动态代理，使用restTemplate实现
     * 自动开启负载均衡策略
     * @param id
     * @return
     */
    @RequestMapping(value="/product/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable("id") Long id);
}
