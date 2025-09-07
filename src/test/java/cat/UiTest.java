package cat;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class UiTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testShowWelcome() {
        Ui.showWelcome();
        String expected = "Hello! I am Meow.\nWhat can I do for you?\n";
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testShowAsk() {
        Ui.showAsk();
        String expected = "Enter any input for me to record down\nor <list> to show all your recorded inputs\nor <bye> to exit.";
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testShowBye() {
        Ui.showBye();
        String expected = "Bye. Hope to see you again soon with Chicken Cat Treats\n";
        assertEquals(expected, outContent.toString());
    }
}