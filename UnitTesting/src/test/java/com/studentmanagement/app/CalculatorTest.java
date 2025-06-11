package com.studentmanagement.app;

import com.studentmanagement.app.service.Calculator;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    Calculator c;

    @BeforeAll
    static void setup() {
        System.out.println("Calculator test is started!");
    }

    @BeforeEach
    void setObject() {
        c = new Calculator();
        System.out.println("Test starting...");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test completed!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All cases tested.");
    }

    @Test
    public void testAddition() {
        Assertions.assertEquals(3, c.add(1, 2));
        Assertions.assertEquals(300, c.add(100, 200));
        Assertions.assertEquals(500, c.add(300, 200));
    }

    @Test
    public void testSubstraction() {
        Assertions.assertEquals(-1, c.substract(1, 2));
        Assertions.assertEquals(-100, c.substract(100, 200));
        Assertions.assertEquals(100, c.substract(300, 200));
    }

    @Test
    public void testMultiplication() {
        Assertions.assertEquals(2, c.multiply(1, 2));
        Assertions.assertEquals(20000, c.multiply(100, 200));
        Assertions.assertEquals(0, c.multiply(0, 200));
    }

    @Test
    @DisplayName("Test Division")
    public void testDivision() {
        Assertions.assertEquals(0, c.division(1, 2));
        Assertions.assertEquals(2, c.division(200, 100));
        Assertions.assertEquals(5, c.division(1000, 200));
    }

    @Test
    @DisplayName("test divide by zero throws exception") // shows this strong in place of the below function name
    public void testDivideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> c.division(5, 0));
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testWithTimeout()  {
        try {
            // This test will fail if it takes more than 2 seconds
            Thread.sleep(2000); // 1 second - will pass
        } catch (InterruptedException e) {
            System.out.println("Time limit exceeded!");
        }
    }
}
