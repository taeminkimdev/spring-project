package com.project.demo.notice.infra;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.project.demo.notice.dto.Notice;

@Mapper
public interface NoticeMapper {
    @Select("SELECT id, title, content, createAt FROM notice")
    public List<Notice> findNotices();

    @Select("SELECT id, title, content, createAt FROM notice WHERE id = #{id}")
    public Notice findNotice(@Param("id") int id);
}
