package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.models.Form.MedicoForm;
import com.seventeam.gsf.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Medico> getById(@PathVariable Integer id)
    {
    	if (id != 0){
    		// TODO: throw Invalid Paramns
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Medico());
	    }
    	
    	Medico medico = medicoService.findById(id);
    	ResponseEntity<Medico> response = ResponseEntity.ok().body(medico);
    	
    	return  response;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Medico> create(@RequestBody MedicoForm form)
    {
	    medicoService.save(form);
	
	    ResponseEntity reponse = ResponseEntity.ok().body(form);
	    return reponse;
    
    }
	
	// TODO: UPDATE
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Medico> create(@PathVariable Integer id, @RequestBody MedicoForm form)
	{
		medicoService.update(form, id);
		
		ResponseEntity reponse = ResponseEntity.ok().body(form);
		return reponse;
		
	}
	
	// TODO: DELETE
	
	
}
