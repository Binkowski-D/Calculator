package calculator_strategy.test;

import calculator_strategy.DivideOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivideOperationTest {

    DivideOperation divideOperation;

    @BeforeEach
    public void setUp(){
        divideOperation = new DivideOperation();
    }

    @Test
    public void testOfDivisionByOne(){
        BigDecimal result = divideOperation.execute(new BigDecimal("5"), BigDecimal.ONE);
        assertEquals(new BigDecimal("5"), result, "5 / 1 should give 5");
    }

    @Test
    public void testOfDivisionByZero(){
        assertThrows(ArithmeticException.class, () -> divideOperation.execute(new BigDecimal("5"), BigDecimal.ZERO), "Do not divide by 0");
    }


//    @Test
//    public void testOfDivisionByZeroWithMessage(){
//        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> divideOperation.execute(new BigDecimal("5"), BigDecimal.ZERO));
//        assertEquals("Do not divide by 0", exception.getMessage(), "The exception message should be : 'Do not divide by 0'");
//    }

}
