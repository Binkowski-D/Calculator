package calculator_strategy;

import java.math.BigDecimal;

public class SubtractOperation implements Operation{
    @Override
    public BigDecimal execute(BigDecimal currentValue, BigDecimal operand) {
        return currentValue.subtract(operand);
    }
}
