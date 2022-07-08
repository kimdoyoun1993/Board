package com.service;

import com.dto.ReplyDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/root-context.xml" )
public class ReplyServiceTests {

    @Autowired
    private ReplyService replyService;

    @Test
    public void testInsert(){

        ReplyDTO replyDTO = new ReplyDTO();

        replyDTO.setBno(65);
        replyDTO.setReplyText("테스트 댓글");
        replyDTO.setReplyer("user00");

        replyService.register(replyDTO);

    }
}
