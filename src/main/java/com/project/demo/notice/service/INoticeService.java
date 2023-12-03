package com.project.demo.notice.service;

import java.util.List;

import com.project.demo.notice.dto.Notice;

public interface INoticeService {
    public List<Notice> getNotices();
    public Notice getNotice(int id);
}
