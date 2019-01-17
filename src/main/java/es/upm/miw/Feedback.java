package es.upm.miw;

public class Feedback {
    private String id;
    private Integer likes;

    public Feedback(String id, Integer likes){
        this.id = id;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLikes(){
        return this.likes;
    }

    public void setLikes(Integer likes){
        this.likes = likes;
    }
}
