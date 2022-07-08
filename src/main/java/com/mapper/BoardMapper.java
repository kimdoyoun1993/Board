package com.mapper;

import com.domain.Board;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BoardMapper extends GenericMapper<Board , Integer>{


    void updateReplyCount(@Param("bno") Integer bno , @Param("amount") int amount);

}
