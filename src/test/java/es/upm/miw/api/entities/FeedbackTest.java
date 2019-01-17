package es.upm.miw.api.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeedbackTest {
    private Feedback feedback = new Feedback("1");

    @Test
    void testId(){
        assertEquals("1", this.feedback.getId());
    }

    @Test
    void testLikes(){
        this.feedback.like();
        this.feedback.like();
        this.feedback.like();
        assertEquals("3", this.feedback.getLikes().toString());
    }
}
