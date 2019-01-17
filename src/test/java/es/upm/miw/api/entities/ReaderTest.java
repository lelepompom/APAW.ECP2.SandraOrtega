package es.upm.miw.api.entities;

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

    @Test
    void testSetName() {
        reader.setName("Almu");
        assertEquals("Almu", reader.getName());
    }

    @Test
    void testSetAge() {
        reader.setAge(41);
        assertEquals("41", reader.getAge().toString());
    }

    @Test
    void testId() {
        reader.setId("1");
        assertEquals("1", reader.getId());
    }

}
