package com.api.board.service.Impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 
import com.api.board.domain.Board;
import com.api.board.mapper.BoardMapper;
import com.api.board.service.BoardService;
 
@Transactional(readOnly = true)
@Service
public class BoardServiceImpl implements BoardService {
 
    @Autowired
    private BoardMapper boardMapper;
 
    public List<Board> getBoardList() throws Exception {
        return boardMapper.getBoardList();
    }
 
    public Board getBoardDetail(int board_seq) throws Exception {
        return boardMapper.getBoardDetail(board_seq);
    };
 
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int insertBoard(Board board) throws Exception {
        return boardMapper.insertBoard(board);
    };
 
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int updateBoard(Board board) throws Exception {
        return boardMapper.updateBoard(board);
    };
 
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int deleteBoard(int board_seq) throws Exception {
        return boardMapper.deleteBoard(board_seq);
    };
}
