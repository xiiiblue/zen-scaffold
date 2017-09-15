package com.bluexiii.zenscaffold.web;

import com.bluexiii.zenscaffold.dto.ProductDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bluexiii on 17/08/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(ProductControllerTest.class);
    @Autowired
    private TestRestTemplate restTemplate;
    @Value("${custom.baseurl}")
    private String baseurl;

    @Test
    public void getProductInfo() throws Exception {
        ResponseEntity<ProductDTO> result = restTemplate.getForEntity(baseurl + "/products/99999830", ProductDTO.class);
        logger.info(result.toString());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().getProductId()).isEqualTo(99999830L);
    }
}