package com.project.demo.notice.dto;

import java.util.List;

public class ResponseNotice {
    private List<Notice> notices;

    public ResponseNotice(List<Notice> notices) {
        this.notices = notices;
    }

    public List<Notice> getNotices() { return this.notices; }
}
