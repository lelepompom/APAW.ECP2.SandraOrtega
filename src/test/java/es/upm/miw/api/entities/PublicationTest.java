package es.upm.miw.api.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PublicationTest {
    private Publication publication =  new Publication("0");
    private List<Reader> readers;

    @BeforeEach
    void before() {
        this.readers = Stream
                .of(
                        new Reader("Sonia", 27),
                        new Reader("Almudena", 25),
                        new Reader("Mario", 24)
                )
                .collect(Collectors.toList());

        this.publication.getBook().setTitle("Clean Code");
    }

    @Test
    void testId(){
        assertEquals("0", this.publication.getId());
    }

    @Test
    void testSigned() {
        assertFalse(publication.getSigned());
    }

    @Test
    void testSigned2() {
        this.publication.setSigned(true);
        assertTrue(publication.getSigned());
    }

    @Test
    void testBookTitle(){
        assertEquals("Clean Code", this.publication.getBook().getTitle());
    }

    @Test
    void testBookAuthor(){
        assertEquals("", this.publication.getBook().getAuthor());
    }

    @Test
    void testGenre() {
        assertNull(this.publication.getGenre());
    }

    @Test
    void testGenre2() {
        publication.setGenre(Genre.MATHS);
        assertEquals(Genre.MATHS, this.publication.getGenre());
    }

    @Test
    void testReader2Name(){
        publication.setReaders(readers);
        assertEquals("Sonia", this.publication.getReaders().get(0).getName());
    }

    @Test
    void testReadersLength() {
        assertEquals(0, this.publication.getReaders().size());
    }

    @Test
    void testPubliDateYear(){
        assertEquals(2019, this.publication.getPubliDate().getYear());
    }
}
