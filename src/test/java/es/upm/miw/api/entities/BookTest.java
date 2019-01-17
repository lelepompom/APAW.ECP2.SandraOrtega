package es.upm.miw.api.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    private Book book;

    @BeforeEach
    void before(){
        this.book = new Book();
        this.book.setTitle("Design as art");
        this.book.setAuthor("Bruno Munari");
    }

    @Test
    void testId(){
        assertEquals("", this.book.getId());
    }

    @Test
    void testTitle(){
        assertEquals("Design as art", this.book.getTitle());
    }

    @Test
    void testAuthor() {
        assertEquals("Bruno Munari", this.book.getAuthor());
    }
}
