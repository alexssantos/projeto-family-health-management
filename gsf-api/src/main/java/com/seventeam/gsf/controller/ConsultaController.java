package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Consulta;
import com.seventeam.gsf.models.dto.ConsultaDto;
import com.seventeam.gsf.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/api/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService ConsultaRepo;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ConsultaDto>> findAll()
    {
        List<Consulta> consultas = ConsultaRepo.findAll();
        List<ConsultaDto> dtoList = consultas.stream().map(bean -> new ConsultaDto(bean)).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtoList);
    }
}
