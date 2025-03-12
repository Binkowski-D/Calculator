package calculator_strategy.test;

import calculator_strategy.AddOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddOperationTest {

    private AddOperation addOperation;

    @BeforeEach
    public void setUp (){
        addOperation = new AddOperation();
    }

    @Test
    public void testZeroAddition(){
        BigDecimal result = addOperation.execute(new BigDecimal("5"), new BigDecimal("0"));
        assertEquals(0, result.compareTo(new BigDecimal("5")), "5 + 0 should give 5");
    }

    @Test
    public void testAdditionWithNegativeNumber(){
        BigDecimal result = addOperation.execute(new BigDecimal("5"), new BigDecimal("-3"));
        assertEquals(0, result.compareTo(new BigDecimal("2")), "5 + (-3) should give 2");
    }

    @Test
    public void testAdditionWithNegativeResult(){
        BigDecimal result = addOperation.execute(new BigDecimal("2"), new BigDecimal("-19"));
        assertEquals(0, result.compareTo(new BigDecimal("-17")), "2 + (-19) should give -17");
    }

}
