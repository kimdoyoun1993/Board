package com.mapper;

import com.domain.Reply;

import java.util.List;

public interface ReplyMapper extends GenericMapper <Reply , Integer>{

    List<Reply> selectListOfBoard(Integer bno);
}
