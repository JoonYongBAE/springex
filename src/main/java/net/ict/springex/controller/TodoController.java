package net.ict.springex.controller;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller //컨트롤러를 사용할 때 사용하는 어노테이션이다.
@RequestMapping("/todo")//
@Log4j2
public class TodoController {

    @RequestMapping("/list")//최종 경로가 '/todo/list'가 된다.
    public void list() {
        log.info("todo list........");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register(){
        log.info("todo register.........");
    }

    //'/todo/register' 를 POST 방식으로 처리하는 메소드 TodoDTO를 파라미터로 적용.
    @PostMapping("/register")
    public String registerPost(TodoDTO todoDTO, RedirectAttributes redirectAttributes){
        log.info("POST todo register.........");
        log.info(todoDTO);
        return "redirect:/todo/list"; //todo/list로 보내준다........
    }


}
