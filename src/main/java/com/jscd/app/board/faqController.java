package com.jscd.app.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class faqController{
    @GetMapping("/board/faq")
    public String faq() {
        return "board/faq";
    }
}
