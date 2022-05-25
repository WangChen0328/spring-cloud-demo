package cn.order.controller;

import cn.order.command.OrderCommand;
import cn.order.po.Product;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wangchen
 * @version 1.0
 * @date 2022/5/2 8:05
 */
@RestController
/**
 * 此接口中公共的熔断设置
 */
@DefaultProperties(defaultFallback = "defaultFallback")
public class OrderController {

    @Autowired
    private RestTemplate template;

    //@HystrixCommand()
    //@SentinelResource(value = "orderRestSentinel", blockHandler = "orderBlackHandler", fallback = "orderFallback")
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        /*if (id != 1) {
            throw new RuntimeException("请求异常");
        }*/
        return template.getForObject("http://SERVICE-PRODUCT/product/" + id, Product.class);
        //return new OrderCommand(template, id).execute();
    }

    /**
     * sentinel 降级逻辑
     * @return
     */
    public Product orderBlackHandler() {
        Product product = new Product();
        product.setProductName("降级逻辑，restTemplate");
        return product;
    }

    /**
     * hystrix 降级| sentinel 报错
     * 降级方法返回值，必须和被保护方法保持一致。
     * 参数一样
     * @HystrixCommand(fallbackMethod = "orderFallback")
     * @return
     */
    public Product orderFallback(Long id) {
        Product product = new Product();
        product.setProductName("报错逻辑，restTemplate");
        return product;
    }

    /**
     * 默认降级方法，参数必须为空。返回值一样
     * @return
     */
    public Product defaultFallback() {
        Product product = new Product();
        product.setProductName("公共降级逻辑，restTemplate");
        return product;
    }

    @RequestMapping(value = "/occupy",method = RequestMethod.GET)
    public Product find() {
        System.out.println(Thread.currentThread().getName());
        Product product = new Product();
        product.setProductName("测试线程占用");
        return product;
    }
}
