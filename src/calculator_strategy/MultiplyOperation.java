package calculator_strategy;

import java.math.BigDecimal;

public class MultiplyOperation implements Operation{
    @Override
    public BigDecimal execute(BigDecimal currentValue, BigDecimal operand) {
        return currentValue.multiply(operand);
    }
}
