package com.project.demo.qna.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.demo.exceptions.NotExistResource;
import com.project.demo.qna.dto.QnA;
import com.project.demo.qna.infra.QnAMapper;
import com.project.demo.util.IdGenerator;

@Component
public class QnAServiceImp implements IQnAService{
    private QnAMapper qnAMapper;

    public QnAServiceImp(QnAMapper qnAMapper) {
        this.qnAMapper = qnAMapper;
    }

    public QnA getQnA(int id) throws NotExistResource{
        QnA qna = this.qnAMapper.findQnA(id);
        if(qna == null) {
            throw new NotExistResource();
        }

        qna.setAnswer();
        return qna;
    }

    public List<QnA> getQnAs(int userId) {
        List<QnA> qnAs = this.qnAMapper.findQnAs(userId);
        for (QnA qna : qnAs) {
            qna.setAnswer();
        }
        return qnAs;
    }

    public void createQnA(int userId, String question) {
        int id = IdGenerator.createId();
        this.qnAMapper.createQnA(id, userId, question, "", new Date());
    }

    public void deleteQnA(int id) {
        this.qnAMapper.deleteQnA(id);
    }

    public void updateQnA(int id, String question) {
        this.qnAMapper.updateQnA(id, question);
    }
}
