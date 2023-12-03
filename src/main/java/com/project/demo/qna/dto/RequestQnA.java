package com.project.demo.qna.dto;

public class RequestQnA {
    private String question;

    public RequestQnA() {}
    public RequestQnA(String question) {
        this.question = question;
    }

    public String getQuestion() { return this.question; }
}
