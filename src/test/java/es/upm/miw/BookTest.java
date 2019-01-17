package es.upm.miw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    private Book book;

    @BeforeEach
    void before(){
        this.book = new Book("Design as art", "Bruno Munari");
    }

    @Test
    void testTitle(){
        assertEquals("Design as art", book.getTitle());
    }

    @Test
    void testAuthor() {
        assertEquals("Bruno Munari", book.getAuthor());
    }
}
