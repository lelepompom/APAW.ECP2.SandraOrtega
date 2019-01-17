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

    public void setName(String name){
        this.name = name;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}
