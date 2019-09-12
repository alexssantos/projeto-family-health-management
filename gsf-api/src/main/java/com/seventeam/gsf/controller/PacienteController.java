package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.models.dto.PacienteDto;
import com.seventeam.gsf.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/api/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @RequestMapping(name = "/getAll", method= RequestMethod.GET)
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PacienteDto> findById(@PathVariable Integer id)
    {
        Paciente obj = pacienteService.findById(id);
        ResponseEntity reponse = ResponseEntity.ok().body(new PacienteDto(obj));
        return reponse;
    }

}
