package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequestMapping("/home")
@Controller
public class HomeController {

    @Autowired
    PacienteService service;

//    @RequestMapping("/")
//    public ModelAndView home() {
//        ModelAndView mav = new ModelAndView("index");
//        mav.addObject("message", "RODOOOOU");
//
//        return mav;
//    }
//
    @GetMapping({"/"})
    public String Home(Model model) {
        String pageName = "index";

        List<Paciente> listaPacientes = service.findAll();
        model.addAttribute("listaPacientes", listaPacientes);

        return pageName;
    }
}
