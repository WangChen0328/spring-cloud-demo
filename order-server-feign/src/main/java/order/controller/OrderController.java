package order.controller;

import order.feign.ProductFeignClient;
import order.po.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangchen
 * @version 1.0
 * @date 2022/5/2 8:05
 */
@RestController
public class OrderController {

    @Autowired
    private ProductFeignClient productFeignClient;

    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        final Product byId = productFeignClient.findById(id);
        return byId;
    }

}
