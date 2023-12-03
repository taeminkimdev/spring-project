package com.api.board.controller;

import com.api.board.dto.BoardRequestDto;
import com.api.board.dto.BoardResponseDto;
import com.api.board.dto.SuccessResponseDto;
import com.api.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor 
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public List<BoardResponseDto> getPosts () {
        return boardService.getPosts();
    }

    @PostMapping("/board")
    public BoardResponseDto createPost(@RequestBody BoardRequestDto requestDto) {
        return boardService.createPost(requestDto);
    }

    @GetMapping("/board/{id}")
    public BoardResponseDto getPost(@PathVariable("id") Long id) {
        return boardService.getPost(id);
    }

    @PatchMapping("/board/{id}")
    public BoardResponseDto updatePost(@PathVariable("id") Long id, @RequestBody BoardRequestDto requestDto) throws Exception{
        return boardService.updatePost(id, requestDto);
    }

    @DeleteMapping("/board/{id}")
    public SuccessResponseDto deletePost(@PathVariable("id") Long id, @RequestBody BoardRequestDto requestDto) throws Exception{
        return boardService.deletePost(id, requestDto);
    }

}
