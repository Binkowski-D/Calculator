package calculator_strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivideOperation implements Operation{
    @Override
    public BigDecimal execute(BigDecimal currentValue, BigDecimal operand) {
        if(operand.compareTo(BigDecimal.ZERO) != 0){
            return currentValue.divide(operand, 2, RoundingMode.HALF_UP);
        }else{
            throw new ArithmeticException("Do not divide by 0");
        }
    }
}
