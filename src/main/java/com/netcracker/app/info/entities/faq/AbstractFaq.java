package com.netcracker.app.info.entities.faq;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractFaq implements Faq {
    @Id
    @GeneratedValue
    private Integer id;

    private String question;
    private String answer;

    @Override
    public int getId() {
        return id;
    }

    public AbstractFaq() {}

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public AbstractFaq(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
