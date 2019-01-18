package es.upm.miw.api.entities;

public class Reader {
    private String id;
    private String name;
    private Integer age;

    public  Reader(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Integer getAge(){
        return this.age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Reader setName(String name){
        this.name = name;
        return this;
    }

    public Reader setAge(Integer age){
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
