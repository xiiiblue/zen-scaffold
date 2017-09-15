package com.bluexiii.zenscaffold.service;

import com.bluexiii.zenscaffold.domain.TdBProduct;
import com.bluexiii.zenscaffold.exception.ResourceNotFoundException;
import com.bluexiii.zenscaffold.repository.TdBProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by bluexiii on 17/08/2017.
 */
@RunWith(SpringRunner.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;

    @MockBean
    private TdBProductRepository tdBProductRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    private TdBProduct mockDiscnt(Long productId) {
        TdBProduct mock = new TdBProduct();
        mock.setProductId(productId);
        return mock;
    }

    @Test
    public void getProductInfo() throws Exception {
        Long productId = 99999830L;
        given(tdBProductRepository.findOne(productId)).willReturn(mockDiscnt(productId));

        TdBProduct productInfo = productService.getProductInfo(99999830L);

        assertThat(productInfo.getProductId()).isEqualTo(productId);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getProductInfoResourceNotFoundException() throws Exception {
        Long productId = 1L;

        productService.getProductInfo(99999830L);
    }
}