package calculator_strategy;

import java.math.BigDecimal;

public class DivideOperation implements Operation{
    @Override
    public BigDecimal execute(BigDecimal currentValue, BigDecimal operand) {
        if(operand.compareTo(BigDecimal.ZERO) != 0){
            return currentValue.divide(operand);
        }else{
            throw new ArithmeticException("Do not divide by 0");
        }
    }
}
