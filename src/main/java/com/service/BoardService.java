package com.service;

import com.dto.BoardDTO;
import com.dto.ListDTO;
import com.dto.ListResponseDTO;

import java.util.List;

public interface BoardService {

    ListResponseDTO<BoardDTO> getList(ListDTO listDTO);

    BoardDTO getOne(Integer bno);

    void update(BoardDTO boardDTO);

    void remove(Integer bno);
}
