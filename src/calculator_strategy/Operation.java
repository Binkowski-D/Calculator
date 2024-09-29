package calculator_strategy;

import java.math.BigDecimal;

public interface Operation {
    BigDecimal execute(BigDecimal currentValue, BigDecimal operand);
}
