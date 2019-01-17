package es.upm.miw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PublicationTest {
    private Publication publication;
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
        this.publication = new Publication(true, "Clean Code", "Robert C. Martin", Genre.MATHS, this.readers);
    }

    @Test
    void testSigned() {
        assertTrue(publication.getSigned());
    }

    @Test
    void testBookTitle(){
        assertEquals("Clean Code", publication.getBook().getTitle());
    }

    @Test
    void testGenre() {
        assertEquals(Genre.MATHS, publication.getGenre());
    }

    @Test
    void testReader2Name(){
        assertEquals("Sonia", publication.getReaders().get(0).getName());
    }
}
