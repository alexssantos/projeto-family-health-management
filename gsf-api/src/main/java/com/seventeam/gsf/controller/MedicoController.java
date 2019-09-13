package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/api/medico")
public class MedicoController
{

    @Autowired
    MedicoService medicoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Medico>> get()
    {
        return getAll();
    }

    @RequestMapping(path = "/getall", method = RequestMethod.GET)
    public ResponseEntity<List<Medico>> getAll()
    {
        List<Medico> medicoList = medicoService.findAll();
        ResponseEntity<List<Medico>> response = ResponseEntity.ok().body(medicoList);

        return response;
    }
}
