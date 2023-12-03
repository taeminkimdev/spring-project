package com.project.demo.qna.infra;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.project.demo.qna.dto.QnA;

@Mapper
public interface QnAMapper {
    @Select("SELECT id, question, answer, createAt FROM qna")
    public List<QnA> findQnAs();

    @Select("SELECT id, question, answer, createAt FROM qna WHERE id = #{id}")
    public QnA findQnA(@Param("id") int id);

    @Insert("INSERT INTO qna (id, question, answer, createAt) VALUE(#{id}, #{question}, #{answer}, #{createAt})")
    public void createQnA(@Param("id") int id, @Param("question") String question, @Param("answer") String answer, @Param("createAt") Date createAt);

    @Delete("DELETE FROM qna WHERE id = #{id}")
    public void deleteQnA(@Param("id") int id);

    @Update("UPDATE qna SET question = #{question} WHERE id = #{id}")
    public void updateQnA(@Param("id") int id, @Param("question") String question);
}
