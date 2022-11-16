package net.ict.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.PageRequestDTO;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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

//    @RequestMapping("/list")//최종 경로가 '/todo/list'가 된다. //페이징 처리 안했을 때의 코드
//    public void list(Model model) {
//        log.info("todo list........");
//
//        model.addAttribute("dtoList", todoService.getAll());
//        //model에는 'dtoList' 이름으로 목록데이터가 담겨있다. 리스트들을 나열해준다.
//    }

    @RequestMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        log.info("todo list........");
        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));

    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register() {
        log.info("todo register.........");
    }

    //'/todo/register' 를 POST 방식으로 처리하는 메소드 TodoDTO를 파라미터로 적용.
    @PostMapping("/register")
    public String registerPost(@Valid /*TodoDTO는 검증의 대상이라는 뜻이다.*/ TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POST todo register.........");

        if (bindingResult.hasErrors()) {//만약 TodoDTO에 title과 writer의 결과에 에러를 담은 바인딩리저트가 있다면
            log.error("has errors....");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDTO);
        todoService.register(todoDTO);
        return "redirect:/todo/list"; //todo/list로 보내준다.!!!!
    }

    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes){
        log.info("remove~~~~~~~~~~~");
        log.info("tno : " + tno);
        todoService.remove(tno);
        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            log.info("has error~~~!");
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno",todoDTO.getTno());
            return "redirect:/todo/modify";
        }
        log.info(todoDTO);
        todoService.modify(todoDTO);
        return "redirect:/todo/list";
    }

    @GetMapping({"/read","/modify"})
    public void read(Long tno, Model model){
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto", todoDTO);
    }

}
