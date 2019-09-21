package com.seventeam.gsf.controller;


import com.seventeam.gsf.domain.Procedimento;
import com.seventeam.gsf.models.Form.ProcedimentoForm;
import com.seventeam.gsf.models.dto.ProcedimentoDto;
import com.seventeam.gsf.services.ProcedimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/procedimento")
public class ProcedimentoController {
	
	@Autowired
	ProcedimentoService procedimentoService;
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<Procedimento>> get()
	{
		return getAll();
	}
	
	@RequestMapping(path = "/getall", method= RequestMethod.GET)
	public ResponseEntity<List<Procedimento>> getAll()
	{
		List<Procedimento> list = procedimentoService.findAll();
		List<ProcedimentoDto> responseList = list.stream()
				.map(item -> new ProcedimentoDto(item))
				.collect(Collectors.toList());
		
		ResponseEntity reponse = ResponseEntity.ok().body(responseList);
		return reponse;
	}
	
	
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity create(@RequestBody ProcedimentoForm form)
	{
		//ValidateForm
		procedimentoService.save(form);
		
		ResponseEntity reponse = ResponseEntity.ok().body(form);
		return reponse;
	}

}
