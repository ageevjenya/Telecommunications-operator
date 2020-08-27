package com.netcracker.app.domain.info.entities.faq;

public interface Faq {
    int getId();
    String getQuestion();
    void setQuestion(String question);
    String getAnswer();
    void setAnswer(String answer);
}
