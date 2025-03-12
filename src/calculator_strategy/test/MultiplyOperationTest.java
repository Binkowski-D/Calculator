package calculator_strategy.test;

import calculator_strategy.MultiplyOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyOperationTest {

    private MultiplyOperation multiplyOperation;

    @BeforeEach
    public void setUp(){
        multiplyOperation = new MultiplyOperation();
    }

    @Test
    public void testMultiplicationByZero(){
        BigDecimal result = multiplyOperation.execute(new BigDecimal("10"), BigDecimal.ZERO);
        assertEquals(0, result.compareTo(BigDecimal.ZERO), "Multiplication by 0 should always give 0");
    }

    @Test
    public void testMultiplicationByOne(){
        BigDecimal result = multiplyOperation.execute(new BigDecimal("10"), BigDecimal.ONE);
        assertEquals(0, result.compareTo(new BigDecimal("10")), "10 * 1 should give 10");
    }

}
