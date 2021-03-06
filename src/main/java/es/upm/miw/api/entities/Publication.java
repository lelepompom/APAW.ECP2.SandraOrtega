package es.upm.miw.api.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publication {
    private String id;
    private Book book;
    private Boolean signed;
    private LocalDateTime publiDate;
    private Genre genre;
    private List<Reader> readers;

    public Publication(Boolean signed, Genre genre, String title){
        this.book = new Book();
        this.book.setTitle(title);
        this.signed = signed;
        this.publiDate = LocalDateTime.now();
        this.genre = genre;
        this.readers = new ArrayList<>();
    }

    public Publication(String id){
        this.id = id;
        this.book = new Book();
        this.signed = false;
        this.publiDate = LocalDateTime.now();
        this.genre = null;
        this.readers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
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

    public void setReader(Reader reader) {
        this.readers.add(reader);
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id='" + id + '\'' +
                ", book=" + book +
                ", signed=" + signed +
                ", publiDate=" + publiDate +
                ", genre=" + genre +
                ", readers=" + readers +
                '}';
    }
}
