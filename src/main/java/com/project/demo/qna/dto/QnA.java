package com.project.demo.qna.dto;

import java.sql.Date;

public class QnA {
    private int id;
    private String question;
    private String answer;
    private Date createAt;

    public QnA(int id, String question, String answer, Date createAt) {
        this.id = id;
        this. question = question;
        this.answer = answer;
        this.createAt = createAt;
    }

    public int getId() { return this.id; }
    public String getQuestion() { return this.question; }
    public String getAnswer() { return this.answer; }
    public Date getCreateAt() { return this.createAt; }
    
    public void setAnswer() {
        if (answer.equals("")){ 
            this.answer = null; 
        }
    }
}
