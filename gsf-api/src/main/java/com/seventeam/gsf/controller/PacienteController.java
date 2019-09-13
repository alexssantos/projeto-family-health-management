package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.models.Form.PacienteForm;
import com.seventeam.gsf.models.dto.PacienteDto;
import com.seventeam.gsf.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/api/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Paciente>> get()
    {
       return getAll();
    }

    @RequestMapping(path = "/getall", method= RequestMethod.GET)
    public ResponseEntity<List<Paciente>> getAll()
    {
        List<Paciente> list = pacienteService.findAll();
        List<PacienteDto> responseList = list.stream()
                .map(item -> new PacienteDto(item))
                .collect(Collectors.toList());

        ResponseEntity reponse = ResponseEntity.ok().body(responseList);
        return reponse;
    }


    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity createPaciente(@RequestBody PacienteForm form)
    {
        //ValidateForm
        pacienteService.save(form);

        ResponseEntity reponse = ResponseEntity.ok().body(form);
        return reponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PacienteDto> findById(@PathVariable Integer id)
    {
        Paciente obj = pacienteService.findById(id);

        ResponseEntity reponse = ResponseEntity.ok().body(new PacienteDto(obj));
        return reponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<PacienteDto> delete(@PathVariable Integer id)
    {
        Paciente obj = pacienteService.findById(id);

        ResponseEntity reponse = ResponseEntity.noContent().build();
        return reponse;
    }

    @RequestMapping("/")
    public String home() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("nome", "Hello Woooorrrrllddd");

        return "index";
    }

}
