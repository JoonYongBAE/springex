package net.ict.springex.controller;

import lombok.extern.log4j.Log4j2;
import net.ict.springex.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void Hello(){
        log.info("hello.........");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age){//결과값 볼 때 /ex1?name="이름입력"&age="나이입력"
        log.info("ex1...........");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name ="name", defaultValue = "AAA") String name, @RequestParam(name = "age", defaultValue = "20")int age){
        //파라미터가 넘어와야하는데 넘어오지 않을 때 기본값을 정해주는 것이다. 결과값을 /ex2로 볼 수있다. 뒤에 이름, 나이를 입력해주지 않으면 기본값이 들어간다.
        log.info("ex222222222");
        log.info("name : " + name);
        log.info("age : " + age);
    }
    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate){
        log.info("ex3..........");
        log.info("dueDate : "+dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model){
        log.info("ex4..........");
        model.addAttribute("message","Hello SpringMVC!!");
    }

    @GetMapping("/ex5")
    public void ex5(TodoDTO todoDTO, Model model){
        log.info("Model ToDTO info..........");
        log.info(todoDTO);
    }

    @GetMapping("/ex6")
    public String ex6(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("name", "ABC");
        //주소값에 뜨는 값이기 때문에 나오지 않는다.
        redirectAttributes.addFlashAttribute("result", "success");
        //웹에서 보여주는 값이기 때문에 결과값이 나온다.
        return "redirect:/ex7";// ex6에서 값을 담고  담은 값을 ex7으로 보낸다.
    }

    @GetMapping("/ex7")
    public void ex7(){
    }

    @GetMapping("/ex8")
    public void ex8(String p1, int p2){
        log.info("p1 ----"+ p1);
        log.info("p2----"+ p2);
    }
}
