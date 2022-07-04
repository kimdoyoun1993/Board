package com.service;

import com.domain.Board;
import com.dto.BoardDTO;
import com.dto.ListDTO;
import com.dto.ListResponseDTO;
import com.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{


    private final BoardMapper boardMapper;
    private final ModelMapper modelMapper;

    @Override
    public ListResponseDTO<BoardDTO> getList(ListDTO listDTO) {
        List<Board> boardList = boardMapper.selectList(listDTO);

        List<BoardDTO> dtoList=
                boardList.stream()
                        .map(board -> modelMapper.map(board,BoardDTO.class))
                        .collect(Collectors.toList());

        return ListResponseDTO.<BoardDTO>builder()
                .dtoList(dtoList)
                .total(boardMapper.getTotal(listDTO))
                .build();
    }

    @Override
    public BoardDTO getOne(Integer bno) {

        Board board = boardMapper.selectOne(bno);

        BoardDTO boardDTO = modelMapper.map(board , BoardDTO.class);

        return boardDTO;
    }

    @Override
    public void update(BoardDTO boardDTO) {
        boardMapper.update(Board.builder()
                        .bno(boardDTO.getBno())
                        .title(boardDTO.getTitle())
                        .content(boardDTO.getContent())
                        .build());
    }

    @Override
    public void remove(Integer bno) {
        boardMapper.delete(bno);
    }
}
