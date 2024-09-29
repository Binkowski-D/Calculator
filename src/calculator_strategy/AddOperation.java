package calculator_strategy;

import java.math.BigDecimal;

public class AddOperation implements Operation{
    @Override
    public BigDecimal execute(BigDecimal currentValue, BigDecimal operand) {
        return currentValue.add(operand);
    }
}
