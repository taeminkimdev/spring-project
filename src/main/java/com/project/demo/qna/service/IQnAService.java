package com.project.demo.qna.service;

import java.util.List;

import com.project.demo.qna.dto.QnA;

public interface IQnAService {
    public List<QnA> getQnAs(int userId);
    public QnA getQnA(int id);
    public void createQnA(int userId, String question);
    public void deleteQnA(int id);
    public void updateQnA(int id, String question);
}
