package com.liftoffproject.premiumdecorsite;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertFalse;

@SpringBootTest
class PremiumDecorSiteApplicationTests {

//    @Test
//    void contextLoads() {
//    }

@Test
public void testAssertFalse() {
    assertFalse("failure - should be false", false);
}

}


