package com.th3.openclass;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
@EntityScan("com.th3.model")
@SpringBootTest
class OpenClassApplicationTests {

    @Test
    void contextLoads() {
    }

}
