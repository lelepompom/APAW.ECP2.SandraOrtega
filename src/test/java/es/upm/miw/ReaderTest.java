package es.upm.miw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReaderTest {
    private Reader reader;

    @BeforeEach
    void before() {
        this.reader = new Reader("Almudena", 25);
    }

    @Test
    void testName() {
        assertEquals("Almudena", reader.getName());
    }

    @Test
    void testAge() {
        assertEquals("25", reader.getAge().toString());
    }

}
