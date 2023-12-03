package com.project.demo.notice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.notice.dto.Notice;
import com.project.demo.notice.dto.ResponseNotice;
import com.project.demo.notice.service.INoticeService;

@RestController
public class NoticeController {
    private INoticeService noticeService;

    public NoticeController(INoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("notice")
    public ResponseNotice getNotices() {
        List<Notice> notices = this.noticeService.getNotices();
        return new ResponseNotice(notices);
    }

    @GetMapping("notice/{id}")
    public Notice getNotice(@PathVariable("id") int id) {
        return this.noticeService.getNotice(id);
    }
}
