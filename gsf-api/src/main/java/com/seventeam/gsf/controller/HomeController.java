package com.seventeam.gsf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class HomeController {

//    @GetMapping
//    public String home(Model m){
//        m.addAttribute("nome", "teste");
//      return "index";
//    }

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Woooorrrrllddd");

        return mav;
    }
}
