package com.project.demo.qna.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.qna.dto.QnA;
import com.project.demo.qna.dto.RequestQnA;
import com.project.demo.qna.dto.ResponseQnA;
import com.project.demo.qna.service.IQnAService;

@RestController
public class QnAController {
    private IQnAService QnAService;

    public QnAController(IQnAService QnAService) {
        this.QnAService = QnAService;
    }

    @GetMapping("QnA")
    public ResponseQnA getQnAs() {
        List<QnA> qnAs = this.QnAService.getQnAs();
        return new ResponseQnA(qnAs);
    }

    @PostMapping("QnA")
    public void createQnA(@RequestBody RequestQnA req) {
        this.QnAService.createQnA(req.getQuestion());
    }

    @GetMapping("QnA/{id}")
    public QnA getQnA(@PathVariable("id") int id) {
        return this.QnAService.getQnA(id);
    }

    @DeleteMapping("QnA/{id}")
    public void deleteQnA(@PathVariable("id") int id) {
        this.QnAService.deleteQnA(id);
    }

    @PatchMapping("QnA/{id}")
    public void updateQnA(@PathVariable("id") int id, @RequestBody RequestQnA req){
        this.QnAService.updateQnA(id, req.getQuestion());
    }
}
