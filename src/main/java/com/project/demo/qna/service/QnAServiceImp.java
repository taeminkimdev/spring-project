package com.project.demo.qna.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.demo.qna.dto.QnA;
import com.project.demo.qna.infra.QnAMapper;
import com.project.demo.util.IdGenerator;

@Component
public class QnAServiceImp implements IQnAService{
    private QnAMapper qnAMapper;

    public QnAServiceImp(QnAMapper qnAMapper) {
        this.qnAMapper = qnAMapper;
    }

    public QnA getQnA(int id) {
        QnA qna = this.qnAMapper.findQnA(id);
        qna.setAnswer();
        return qna;
    }

    public List<QnA> getQnAs() {
        List<QnA> qnAs = this.qnAMapper.findQnAs();
        for (QnA qna : qnAs) {
            qna.setAnswer();
        }
        return qnAs;
    }

    public void createQnA(String question) {
        int id = IdGenerator.createId();
        this.qnAMapper.createQnA(id, question, "", new Date());
    }

    public void deleteQnA(int id) {
        this.qnAMapper.deleteQnA(id);
    }

    public void updateQnA(int id, String question) {
        this.qnAMapper.updateQnA(id, question);
    }
}
