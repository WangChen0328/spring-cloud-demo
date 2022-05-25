package order.feign;

import order.po.Product;
import org.springframework.stereotype.Component;

/**
 * @Author wangchen
 * @Date 2022/5/7 7:53
 */
@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product findById(Long id) {
        Product product = new Product();
        product.setProductName("feign的接口降级方法");
        return product;
    }
}
