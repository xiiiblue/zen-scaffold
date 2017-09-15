package com.bluexiii.zenscaffold.client;

import com.bluexiii.zenscaffold.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bluexiii on 17/08/2017.
 */
@FeignClient(name = "marathon-lb-internal", fallback = StaticInfoClientFallback.class, decode404 = true)
@RequestMapping(value = "/sd/staticinfo")
public interface StaticInfoClient {
    /**
     * 产品定义询查询客户端
     *
     * @param productId 99999830
     * @return
     */
    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public ProductDTO getProductInfo(@PathVariable("productId") Long productId);
}

@Component
class StaticInfoClientFallback implements StaticInfoClient {
    private static final Logger logger = LoggerFactory.getLogger(StaticInfoClientFallback.class);

    @Override
    public ProductDTO getProductInfo(Long productId) {
        logger.error("StaticInfoClient.getProductInfo 执行失败");

        ProductDTO dto = new ProductDTO();
        dto.setProductId(productId);
        dto.setProductName("产品名称暂时无法获取");
        return dto;
    }
}