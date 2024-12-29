package restaurant.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ConsoleUtilsTest {
    private ConsoleUtils consoleUtils;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("Test Read Line")
    public void testGetString() {
        String input = "Entrada de prueba";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String result = consoleUtils.getString("Introduce la entrada: ");
        assertEquals("Entrada de prueba", result);
    }

    @Test
    public void testGetInteger() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = consoleUtils.getInteger("Introduce el número: ");
        assertEquals(5, result);
    }

    @Test
    public void testGetDouble() {
        String input = "5.0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        double result = consoleUtils.getDouble("Introduce el número decimal: ");
        assertEquals(5.0, result);
    }
}