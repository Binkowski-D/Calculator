package calculator_strategy;

public class OperationFactory {

    public Operation createOperation(String operationType){
        return switch (operationType.toLowerCase()){
            case "add" -> new AddOperation();
            case "subtract" -> new SubtractOperation();
            case "multiply" -> new MultiplyOperation();
            case "divide" -> new DivideOperation();
            default -> throw new IllegalArgumentException("Invalid operation type: " + operationType);
        };
    }
}
