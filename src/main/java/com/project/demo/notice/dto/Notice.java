package com.project.demo.notice.dto;

import java.sql.Date;

public class Notice {
    private int id;
    private String title;
    private String content;
    private Date createAt;
    
    public Notice(int id, String title, String content, Date createAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
    }

    public int getId() { return this.id; }
    public String getTitle() { return this.title; }
    public String getContent() { return this.content; }
    public Date getCreateAt() { return this.createAt; }
}
