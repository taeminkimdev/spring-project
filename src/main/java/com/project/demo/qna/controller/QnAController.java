package com.project.demo.qna.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.auth.domain.User;
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
    public ResponseQnA getQnAs(HttpSession session) {
        User user = (User)session.getAttribute("user");

        List<QnA> qnAs = this.QnAService.getQnAs(user.getId());
        return new ResponseQnA(qnAs);
    }

    @PostMapping("QnA")
    public void createQnA(HttpSession session, @RequestBody RequestQnA req) {
        User user = (User)session.getAttribute("user");
        this.QnAService.createQnA(user.getId(), req.getQuestion());
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
