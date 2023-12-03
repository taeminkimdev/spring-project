package com.project.demo.qna.dto;

import java.util.List;

public class ResponseQnA {
    private List<QnA> qans;

    public ResponseQnA(List<QnA> qans) {
        this.qans = qans;
    }

    public List<QnA> getQans() { return this.qans; }
}
