package com.mapper;

import com.domain.Board;
import com.dto.ListDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GenericMapper <E,K>{

    void insert(E board);

    List<Board> selectList(ListDTO listDTO);

    void delete(K bno);

    Board selectOne(K bno);

    void update(E board);

    int getTotal(ListDTO listDTO);
}
