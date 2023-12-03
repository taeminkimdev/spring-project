package com.project.demo.notice.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.demo.notice.dto.Notice;
import com.project.demo.notice.infra.NoticeMapper;

@Component
public class NoticeServiceImp implements INoticeService{
    private NoticeMapper noticeMapper;

    public NoticeServiceImp(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public Notice getNotice(int id) {
        return this.noticeMapper.findNotice(id);
    }

    public List<Notice> getNotices() {
        return this.noticeMapper.findNotices();
    }
}
