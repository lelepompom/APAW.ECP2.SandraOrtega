package es.upm.miw.api.dtos;

import es.upm.miw.api.entities.Reader;

public class ReaderIdNameDto {

    private String id;

    private String name;

    public ReaderIdNameDto(Reader reader) {
        this.id = reader.getId();
        this.name = reader.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String reference) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReaderIdNameDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
