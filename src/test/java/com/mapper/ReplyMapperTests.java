package com.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/root-context.xml" )
public class ReplyMapperTests {

    @Autowired(required = false)
    private ReplyMapper mapper;

    @Test
    public void testList1(){

        Integer bno = 69;

        mapper.selectListOfBoard(bno).forEach(reply -> log.info(reply));
    }
}
