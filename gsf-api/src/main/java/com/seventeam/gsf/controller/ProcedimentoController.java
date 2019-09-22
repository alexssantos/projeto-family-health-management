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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/")
public class ProcedimentoController {
	
	@Autowired
	ProcedimentoService procedimentoService;

//	@RequestMapping("/procedimentos")
//	public ModelAndView procedimentos() {
//		List<Procedimento> listaProcedimentos = service.findAll();
//		ModelAndView mav = new ModelAndView("procedimentos");
//		mav.addObject("listaProcedimentos", listaProcedimentos);
//
//		return mav;
//	}

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
		procedimentoService.save(form);

		ResponseEntity reponse = ResponseEntity.ok().body(form);
		return reponse;
	}
}
