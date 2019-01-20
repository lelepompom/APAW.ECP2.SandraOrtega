package es.upm.miw.api.dtos;

import es.upm.miw.api.entities.Publication;

public class PublicationIdTitleDto {
    private String id;

    private String title;

    public PublicationIdTitleDto(Publication publication) {
        this.id = publication.getId();
        this.title = publication.getBook().getTitle();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PublicationIdTitleDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
