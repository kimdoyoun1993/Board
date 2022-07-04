package com.controller;

import com.dto.BoardDTO;
import com.dto.ListDTO;
import com.dto.ListResponseDTO;
import com.dto.PageMaker;
import com.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String basic(){

        return  "redirect:/board/list";
    }

    @GetMapping("/read/{bno}")
    public String read(@PathVariable("bno") Integer bno , ListDTO listDTO , Model model){

        log.info("==============");

        log.info(bno);

        log.info(listDTO);

        return "/board/read";
    }

    @GetMapping("/modify/{bno}")
    public String modify(@PathVariable("bno") Integer bno , ListDTO listDTO, Model model){

        log.info("==============");

        log.info(bno);

        log.info(listDTO);

        model.addAttribute("dto", boardService.getOne(bno));

        return "/board/modify";
    }

    //void 일때는 자동으로 경로를 타게됨
    @GetMapping("/list")
    public void list(ListDTO listDTO , Model model){

        log.info("board list.........");

        log.info(listDTO);

        ListResponseDTO<BoardDTO> responseDTO = boardService.getList(listDTO);

        model.addAttribute("dtoList",responseDTO.getDtoList());

        int total = responseDTO.getTotal();
        model.addAttribute("pageMaker",new PageMaker(listDTO.getPage(),total));

    }

    @GetMapping("/register")
    public void registerGET(){

    }

    @PostMapping("/register")
    public String registerPOST(BoardDTO boardDTO , RedirectAttributes rttr){

        log.info("----------------------");
        log.info(boardDTO);

        rttr.addFlashAttribute("result",123);

        return "redirect:/board/list";
    }

    @PostMapping("/remove/{bno}")
    public String removePost(@PathVariable("bno") Integer bno , RedirectAttributes rttr){
        log.info("--------------");
        log.info("--------------");
        log.info("remove" + bno);

        boardService.remove(bno);

        log.info("--------------");

        rttr.addFlashAttribute("result","removed");

        return "redirect:/board/list";
    }

    @PostMapping("/modify/{bno}")
    public String removePost(@PathVariable("bno") Integer bno ,BoardDTO boardDTO ,ListDTO listDTO , RedirectAttributes rttr){
        log.info("--------------");
        log.info("--------------");
        boardDTO.setBno(bno);
        log.info("modify" + boardDTO);

        boardService.update(boardDTO);

        log.info("--------------");

        rttr.addFlashAttribute("result","modified");

        return "redirect:/board/read/"+bno + listDTO.getLink();
    }

    @GetMapping({"/remove/{bno}"})
    public String getNotSupported(){
        return "redirect:/board/list";
    }
}
