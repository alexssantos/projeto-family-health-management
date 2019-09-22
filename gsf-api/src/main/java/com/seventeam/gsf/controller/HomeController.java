package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Procedimento;
import com.seventeam.gsf.services.PacienteService;
import com.seventeam.gsf.services.ProcedimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RequestMapping( value = "/" )
@Controller
public class HomeController {

    @Autowired
    ProcedimentoService service;

//    @RequestMapping("/")
//    public ModelAndView home() {
//        ModelAndView mav = new ModelAndView("index");
//        mav.addObject("message", "RODOOOOU");
//
//        return mav;
//    }
//
//    @RequestMapping("/")
//    public ModelAndView home() {
//        List<Paciente> listaPacientes = service.findAll();
//        System.out.println(listaPacientes);
//        ModelAndView mav = new ModelAndView("index");
//        mav.addObject("listaPacientes", listaPacientes);
//
//        return mav;
//    }
//
//    @RequestMapping( path = "/" )
//    public String home() {
//
//        return "index";
//    }

//    @RequestMapping("/")
//    public ModelAndView procedimentos() {
//        List<Procedimento> listaProcedimentos = service.findAll();
//        ModelAndView mav = new ModelAndView("index");
//        mav.addObject("listaProcedimentos", listaProcedimentos);
//
//        return mav;
//    }

    @RequestMapping(value = "/login_medico")
    public String login_medico() {
        return "login_medico";
    }

//    @RequestMapping(value = "/procedimentos")
//    public String procedimentos() {
//        return "procedimentos";
//    }

//    @RequestMapping("/login_gestante")
//    public ModelAndView home() {
//        List<Paciente> listaPacientes = service.findAll();
//        System.out.println(listaPacientes);
//        ModelAndView mav = new ModelAndView("login_gestante");
//        mav.addObject("listaPacientes", listaPacientes);
//
//        return mav;
//    }
}
