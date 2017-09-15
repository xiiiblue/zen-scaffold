package com.bluexiii.zenscaffold.service;

import com.bluexiii.zenscaffold.domain.TdBProduct;
import com.bluexiii.zenscaffold.exception.ResourceNotFoundException;
import com.bluexiii.zenscaffold.repository.TdBProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bluexiii on 11/08/2017.
 */
@Service
public class ProductService {
    @Autowired
    private TdBProductRepository tdBProductRepository;

    /**
     * 查询产品定义
     *
     * @param productId
     * @return
     */
    public TdBProduct getProductInfo(Long productId) {
        TdBProduct tdBProduct = tdBProductRepository.findOne(productId);
        if (tdBProduct == null) {
            throw new ResourceNotFoundException(String.format("不存在 productId=%s", productId));
        }
        return tdBProduct;
    }
}
