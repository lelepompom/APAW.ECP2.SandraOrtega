package es.upm.miw.api.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Publication {
    private String id;
    private Boolean signed;
    private LocalDateTime publiDate;
    private Book book;
    private Genre genre;
    private List<Reader> readers;

    public Publication(Boolean signed, String title, String author, Genre genre, List<Reader> readers){
        this.signed = signed;
        this.publiDate = LocalDateTime.now();
        this.book = new Book(title, author);
        this.genre = genre;
        this.readers = readers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSigned() {
        return signed;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }

    public LocalDateTime getPubliDate() {
        return publiDate;
    }

    public void setPubliDate(LocalDateTime publiDate) {
        this.publiDate = publiDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }
}
