package com.progdistribuee.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VolController {

    @GetMapping("/greeting")
    public String greeting() {
        return "greeting";
    }

}