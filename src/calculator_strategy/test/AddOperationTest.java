package calculator_strategy.test;

import calculator_strategy.AddOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddOperationTest {

    AddOperation addOperation;

    @BeforeEach
    public void setUp (){
        addOperation = new AddOperation();
    }

    @Test
    public void zeroAdditionTest(){
        BigDecimal result = addOperation.execute(new BigDecimal("5"), new BigDecimal("0"));
        assertEquals(new BigDecimal("5"), result, "5 + 0 should give 5");
    }

    @Test
    public void testAdditionWithNegativeNumber(){
        BigDecimal result = addOperation.execute(new BigDecimal("5"), new BigDecimal("-3"));
        assertEquals(new BigDecimal("2"), result, "5 + -3 should give 2");
    }

    @Test
    public void testAdditionWithNegativeResult(){
        BigDecimal result = addOperation.execute(new BigDecimal("2"), new BigDecimal("-19"));
        assertEquals(new BigDecimal("-17"), result, "2 + -19 should give -17");
    }

}
