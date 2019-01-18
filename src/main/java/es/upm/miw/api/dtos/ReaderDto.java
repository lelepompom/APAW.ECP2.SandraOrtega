package es.upm.miw.api.dtos;

public class ReaderDto {

    private String name;
    private int age;

    public ReaderDto(String name, int age){
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

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ReaderDto{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
