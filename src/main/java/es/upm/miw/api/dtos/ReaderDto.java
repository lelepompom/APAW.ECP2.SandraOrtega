package es.upm.miw.api.dtos;

public class ReaderDto {

    private String name;
    private Integer age;

    public ReaderDto(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public ReaderDto(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
