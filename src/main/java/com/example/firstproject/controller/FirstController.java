package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        // greetings 뷰에 있는 username이라는 변수에 "people" 이라는 값을 넣어줌
        // 타입을 선언하지 않아도 적용되는 이유는 model 인터페이스가 다양한 데이터 타입을 Object로 제공하기 때문
        model.addAttribute("username", "people");
        return "greetings";
    }

    @GetMapping("/bye")
    public String bye(Model model){
        model.addAttribute("username", "people");
        return "bye";
    }
}
