package es.upm.miw.api.dtos;

import es.upm.miw.api.entities.Genre;

public class PublicationDto {

    private Boolean signed;
    private Genre genre;
    private String title;

    public PublicationDto(Boolean signed, Genre genre, String title){
        this.signed = signed;
        this.genre = genre;
        this.title = title;
    }

    public PublicationDto(String title){
        this.title = title;
    }

    public Boolean getSigned() {
        return signed;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String isSigned(Boolean signed){
        return signed ? "yes" : "no";
    }

    @Override
    public String toString() {
        return "PublicationDto{" +
                "signed='" + isSigned(signed) + '\'' +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
