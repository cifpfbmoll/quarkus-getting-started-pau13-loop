package edu.pingpong.quickstart.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuestionService {

    private final String QUESTION = "We accept the love we think we deserve ?";
    
    public String randomQuestion() {
        return this.QUESTION;
    }
}
