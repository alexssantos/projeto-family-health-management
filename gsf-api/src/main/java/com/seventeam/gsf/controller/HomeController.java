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

    @RequestMapping(value = "/")
    public String home() {
        return "/home";
    }
}
