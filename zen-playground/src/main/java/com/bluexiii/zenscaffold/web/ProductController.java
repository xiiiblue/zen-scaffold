package com.bluexiii.zenscaffold.web;

import com.bluexiii.zenscaffold.component.StaticModelMapperComponent;
import com.bluexiii.zenscaffold.domain.TdBProduct;
import com.bluexiii.zenscaffold.dto.ProductDTO;
import com.bluexiii.zenscaffold.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by bluexiii on 11/08/2017.
 */
@RestController
@Api(value = "产品静态配置", description = "产品静态配置")
@RequestMapping("${custom.baseurl}/products/")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private StaticModelMapperComponent staticModelMapperComponent;

    @Cacheable("getProductInfo")
    @HystrixCommand(
            fallbackMethod = "",  // Use Exception Handler
            ignoreExceptions = {Exception.class}
    )
    @ApiOperation(value = "查询产品配置")
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProductDTO getProductInfo(@ApiParam(value = "产品编码", defaultValue = "99999830", required = true)
                                     @PathVariable Long productId) {
        TdBProduct productInfo = productService.getProductInfo(productId);
        return staticModelMapperComponent.productEntityToDTO(productInfo);
    }
}