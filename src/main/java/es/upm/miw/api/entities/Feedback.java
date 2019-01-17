package es.upm.miw.api.entities;

public class Feedback {
    private String id;
    private Integer likes;

    public Feedback(String id){
        this.id = id;
        this.likes = 0;
    }

    public String getId() {
        return id;
    }

    public Integer getLikes(){
        return this.likes;
    }

    public void like() {
        this.likes++;
    }
}
