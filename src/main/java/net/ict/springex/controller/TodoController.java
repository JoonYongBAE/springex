package net.ict.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller //컨트롤러를 사용할 때 사용하는 어노테이션이다.
@RequestMapping("/todo")//
@Log4j2
@RequiredArgsConstructor //롬복 라이브러리에 존재
public class TodoController {

    private final TodoService todoService;//어노테이션 아규먼트컨스트럭터가 필요하다

    @RequestMapping("/list")//최종 경로가 '/todo/list'가 된다.
    public void list(Model model) {
        log.info("todo list........");

        model.addAttribute("dtoList",todoService.getAll());
        //model에는 'dtoList' 이름으로 목록데이터가 담겨있다.
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register(){
        log.info("todo register.........");
    }

    //'/todo/register' 를 POST 방식으로 처리하는 메소드 TodoDTO를 파라미터로 적용.
    @PostMapping("/register")
    public String registerPost(@Valid /*TodoDTO는 검증의 대상이라는 뜻이다.*/ TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("POST todo register.........");

        if(bindingResult.hasErrors()){//만약 TodoDTO에 title과 writer의 결과에 에러를 담은 바인딩리저트가 있다면
            log.error("has errors....");
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDTO);
        todoService.register(todoDTO);
        return "redirect:/todo/list"; //todo/list로 보내준다.!!!!
    }


}
