package com.studentmanagement.app;

import com.studentmanagement.app.service.StockService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StockServiceTest {

    @Test
    void testStock() {

        StockService st = new StockService(5);

        Assertions.assertEquals(50, st.getStock());
        st.updateStock(50);
        Assertions.assertEquals(50, st.getStock());
    }
}
