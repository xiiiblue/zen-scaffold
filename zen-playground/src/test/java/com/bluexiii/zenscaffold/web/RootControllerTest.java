package com.bluexiii.zenscaffold.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by bluexiii on 25/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RootControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Value("${custom.baseurl}")
    private String baseurl;
    private static final Logger logger = LoggerFactory.getLogger(RootControllerTest.class);

    @Test
    public void rootRedirect() throws Exception {
        ResponseEntity<String> result = restTemplate.exchange("/",
                HttpMethod.GET, new HttpEntity(null), String.class);
        logger.info(result.toString());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}