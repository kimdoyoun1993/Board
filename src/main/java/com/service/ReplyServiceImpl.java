package com.service;

import com.domain.Reply;
import com.dto.ReplyDTO;
import com.mapper.BoardMapper;
import com.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReplyServiceImpl implements ReplyService{

    private final ReplyMapper replyMapper;
    private final ModelMapper modelMapper;
    private final BoardMapper boardMapper;

    @Override
    public List<ReplyDTO> getListOfboard(Integer bno) {

        List<Reply> replyList = replyMapper.selectListOfBoard(bno);

        List<ReplyDTO> dtoList = replyList.stream()
                .map(reply -> modelMapper.map(reply,ReplyDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public void register(ReplyDTO replyDTO) {

        Reply reply = modelMapper.map(replyDTO, Reply.class);

        replyMapper.insert(reply);

        boardMapper.updateReplyCount(replyDTO.getBno(),1);
    }
}
