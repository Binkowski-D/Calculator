package calculator_strategy;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CalculatorApp {
    private static final String path = "src/calculator_strategy/resources/mathematical_operations.txt";

    public static void main(String[] args) {

        try {
            processFile(path);
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }

    private static List<List<String>> readInstructionSets(String path) throws IOException {
        List<String> instructionLinesFromFile = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        List<List<String>> instructionSets = new ArrayList<>();
        List<String> currentSet = new ArrayList<>();

        for (String line : instructionLinesFromFile) {
            if (!line.isEmpty()) {
                currentSet.add(line);
            } else {
                if (!currentSet.isEmpty()) {
                    instructionSets.add(currentSet);
                    currentSet = new ArrayList<>();
                }
            }
        }
        if (!currentSet.isEmpty()) {
            instructionSets.add(currentSet);
        }
        return instructionSets;
    }

    public static void processFile(String filePath) throws IOException {
        List<List<String>> instructionSets = readInstructionSets(filePath);
        if (instructionSets.isEmpty()) {
            System.out.println("File is empty, no instructions to process.");
            return;
        }
        final OperationFactory operationFactory = new OperationFactory();

        for (List<String> instructionSet : instructionSets) {
            BigDecimal currentValue = BigDecimal.ZERO;

            for (String instruction : instructionSet) {
                String[] instructionParts = instruction.split(" ");

                if (instructionParts[0].equals("apply")) {
                    currentValue = new BigDecimal(instructionParts[1]);
                    break;
                }
            }
            BigDecimal operand;
            for (String instructionLine : instructionSet) {
                String[] instructionParts = instructionLine.split(" ");

                switch (instructionParts[0]) {
                    case "apply" -> {}
                    case "add", "subtract", "multiply", "divide" -> {
                        operand = new BigDecimal(instructionParts[1]);
                        Operation operation = operationFactory.createOperation(instructionParts[0]);
                        currentValue = operation.execute(currentValue, operand);
                    }
                    default -> throw new IllegalArgumentException("Unknown operation: " + instructionParts[0] + ". Allowed operations: add, subtract, multiply, divide.");
                }
            }
            System.out.println("Result: " + currentValue);
        }
    }
}
