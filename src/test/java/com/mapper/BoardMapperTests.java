package com.mapper;

import com.domain.Board;
import com.dto.ListDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/root-context.xml" )
public class BoardMapperTests {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    @Test
    public void testInsert(){

        for (int i = 0; i <50 ; i++) {
            Board board = Board.builder().title("제목"+i).content("내용"+i).writer("user"+i).build();

            boardMapper.insert(board);
        }

    }

    @Test
    public void testSelectList(){

        ListDTO listDTO = new ListDTO();


        listDTO.setType("t");
//        listDTO.setKeyword("제목");

        List<Board> boardList = boardMapper.selectList(listDTO);

        boardList.forEach(board -> log.info(board));
    }

    @Test
    public void testSelectOne(){
        int bno = 13;

        Board board =boardMapper.selectOne(bno);

        log.info(board);
    }

    @Test
    public void testDelete(){
        int bno = 21;

        boardMapper.delete(bno);
    }


}
