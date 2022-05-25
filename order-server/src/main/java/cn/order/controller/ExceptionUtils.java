package cn.order.controller;

import cn.order.po.Product;
import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * @author wangchen
 * @version 1.0
 * @date 2022/5/11 14:52
 */
public class ExceptionUtils {

    public static SentinelClientHttpResponse handlerBlock(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException e) {
        Product product = new Product();
        product.setProductName("熔断");
        return new SentinelClientHttpResponse(JSON.toJSONString(product));
    }

    public static SentinelClientHttpResponse handlerFallback(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException e) {
        Product product = new Product();
        product.setProductName("异常");
        return new SentinelClientHttpResponse(JSON.toJSONString(product));
    }

}
