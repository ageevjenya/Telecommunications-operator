package com.netcracker.app.domain.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String textAnswer;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "beforeQuestion_id")
    private Question beforeQuestion;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "afterQuestion_id")
    private Question afterQuestion;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "functionChat_id")
    private FunctionChat functionChat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public Question getBeforeQuestion() {
        return beforeQuestion;
    }

    public void setBeforeQuestion(Question beforeQuestion) {
        this.beforeQuestion = beforeQuestion;
    }

    public Question getAfterQuestion() {
        return afterQuestion;
    }

    public void setAfterQuestion(Question afterQuestion) {
        this.afterQuestion = afterQuestion;
    }

    public FunctionChat getFunctionChat() {
        return functionChat;
    }

    public void setFunctionChat(FunctionChat functionChat) {
        this.functionChat = functionChat;
    }
}
