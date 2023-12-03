package com.api.board.mapper;

import java.util.List;

import com.api.board.domain.Board;

public interface BoardMapper {
	
    public List<Board> getBoardList() throws Exception;
    
    public Board getBoardDetail(int board_seq) throws Exception;
    
    public int insertBoard(Board board) throws Exception;  
    
    public int updateBoard(Board board) throws Exception;
    
    public int deleteBoard(int board_seq) throws Exception;
}
