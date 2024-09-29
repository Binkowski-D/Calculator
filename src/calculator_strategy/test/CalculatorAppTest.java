package calculator_strategy.test;

import calculator_strategy.CalculatorApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorAppTest {

    String filePath;

    @BeforeEach
    public void setUp(){
        filePath = "src/calculator_strategy/test/resources/";
    }

//    @AfterEach
//    public void tearDown() {
//        try {
//            Files.deleteIfExists(Paths.get(filePath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void invalidDataTest(){
        filePath += "invalid_data.txt";

        try{
            Files.writeString(Paths.get(filePath), "apply add", StandardCharsets.UTF_8);
        }catch(IOException ex){
            ex.printStackTrace();
        }

        assertThrows(NumberFormatException.class, () -> CalculatorApp.processFile(filePath), "Expected NumberFormatException for invalid number format");
    }

    @Test
    public void invalidOperationTest(){
        filePath += "invalid_operation.txt";
        try{
            Files.writeString(Paths.get(filePath), "adddddd 125", StandardCharsets.UTF_8);
        }catch (IOException ex){
            ex.printStackTrace();
        }

        assertThrows(IllegalArgumentException.class, () -> CalculatorApp.processFile(filePath), "Expected IllegalArgumentException for invalid operation format");
    }
}
