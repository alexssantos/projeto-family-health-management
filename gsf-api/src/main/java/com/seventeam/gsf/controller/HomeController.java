package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RequestMapping("/")
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
    @RequestMapping("/")
    public ModelAndView home() {
        List<Paciente> listaPacientes = service.findAll();
        System.out.println(listaPacientes);
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listaPacientes", listaPacientes);

        return mav;
    }
}
