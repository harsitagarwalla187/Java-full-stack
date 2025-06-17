package com.studentmanagement.app;

import com.studentmanagement.app.service.DiscountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountServiceTest {

    @Test
    public void testPremiumDiscount() {

        DiscountService ds = new DiscountService();
        double discount = ds.calculateDiscount("PREMIUM", 2000);
        Assertions.assertEquals(200.0, discount);
    }
}
