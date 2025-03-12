package calculator_strategy.test;

import calculator_strategy.CalculatorApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorAppTest {

    private static final String BASE_PATH = "src/calculator_strategy/test/resources/";
    private final List<Path> createdFiles = new ArrayList<>();

    @BeforeEach
    public void setUp() throws  IOException {
        Files.createDirectories(Paths.get(BASE_PATH));
    }

    @AfterEach
    public void tearDown() throws IOException {
        for (Path file : createdFiles) {
            Files.deleteIfExists(file);
        }
        createdFiles.clear();
    }

    @Test
    public void testInvalidData() throws IOException {
        Path filePath = Paths.get(BASE_PATH, "invalid_data.txt");
        Files.writeString(filePath, "apply add", StandardCharsets.UTF_8);
        createdFiles.add(filePath);

        assertThrows(NumberFormatException.class, () -> CalculatorApp.processFile(filePath.toString()),
                "Expected NumberFormatException for invalid number format");
    }

    @Test
    public void testInvalidOperation() throws IOException {
        Path filePath = Paths.get(BASE_PATH, "invalid_operation.txt");
        Files.writeString(filePath, "adddddd 125", StandardCharsets.UTF_8);
        createdFiles.add(filePath);

        assertThrows(IllegalArgumentException.class, () -> CalculatorApp.processFile(filePath.toString()),
                "Expected IllegalArgumentException for invalid operation format");
    }
}