package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/api/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Paciente>> findAll()
    {
        List<Paciente> list = pacienteService.findAll();

        int qtdd = list.size();

        return ResponseEntity.ok().body(list);
    }


    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity createPaciente()
    {
        Paciente newObj = new Paciente();
        newObj.setNome("Alex");
        pacienteService.save(newObj);

        return ResponseEntity.ok().body(newObj);
    }

    @RequestMapping("/")
    public String home() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("nome", "Hello Woooorrrrllddd");

        return "index";
    }

}
