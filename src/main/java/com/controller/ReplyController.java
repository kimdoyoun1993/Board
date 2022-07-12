package com.controller;

import com.dto.ReplyDTO;
import com.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/replies/")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;


    @PostMapping("/")
    public Map<String , Integer> regiser(@RequestBody ReplyDTO replyDTO){
        log.info("=====================");
        log.info(replyDTO);

        replyService.register(replyDTO);

        return Map.of("result",135);
    }

    @GetMapping("/test")
    public String[] get1() {
        return new String[]{"AAA","BBB","CCC"};
    }

    @GetMapping(value = "/list/{bno}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReplyDTO> getListOfBoard(@PathVariable("bno") Integer bno){

        return replyService.getListOfboard(bno);
    }
}
