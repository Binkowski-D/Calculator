package calculator_strategy.test;

import calculator_strategy.MultiplyOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyOperationTest {

    MultiplyOperation multiplyOperation;

    @BeforeEach
    public void setUp(){
        multiplyOperation = new MultiplyOperation();
    }

    @Test
    public void testMultiplicationByZero(){
        BigDecimal result = multiplyOperation.execute(new BigDecimal("10"), BigDecimal.ZERO);
        assertEquals(BigDecimal.ZERO, result, "Multiplication by 0 always should give 0");
    }

    @Test
    public void testMultiplicationByOne(){
        BigDecimal result = multiplyOperation.execute(new BigDecimal("10"), BigDecimal.ONE);
        assertEquals(new BigDecimal("10"), result, "10 * 1 should give 10");
    }

}
