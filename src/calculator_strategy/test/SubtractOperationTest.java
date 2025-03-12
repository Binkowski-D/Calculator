package calculator_strategy.test;

import calculator_strategy.SubtractOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractOperationTest {

    private SubtractOperation subtractOperation;

    @BeforeEach
    public void setUp(){
        subtractOperation = new SubtractOperation();
    }

    @Test
    public void testSubtractionFromZero(){
        BigDecimal result = subtractOperation.execute(BigDecimal.ZERO, new BigDecimal("5"));
        assertEquals(0, result.compareTo(new BigDecimal("-5")), "0 - 5 should give -5");
    }

    @Test
    public void testSubtractionOfNumberFromItself(){
        BigDecimal result = subtractOperation.execute(new BigDecimal("5"), new BigDecimal("5"));
        assertEquals(0, result.compareTo(BigDecimal.ZERO), "5 - 5 should give 0");
    }

    @Test
    public void testSubtractionWithNegativeNumber(){
        BigDecimal result = subtractOperation.execute(new BigDecimal("4"), new BigDecimal("-5"));
        assertEquals(0, result.compareTo(new BigDecimal("9")), "4 - (-5) should give 9");
    }

}
