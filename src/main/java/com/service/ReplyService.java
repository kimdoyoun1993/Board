package com.service;

import com.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {

    List<ReplyDTO> getListOfboard(Integer bno);

    void register(ReplyDTO replyDTO);
}
