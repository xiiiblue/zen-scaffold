package com.bluexiii.zenscaffold;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by bluexiii on 25/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaygroundApplicationTest {
    @Test
    public void main() throws Exception {
        PlaygroundApplication playgroundApplication = new PlaygroundApplication();
        playgroundApplication.main(new String[]{});
    }
}