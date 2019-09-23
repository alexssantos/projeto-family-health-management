package com.seventeam.gsf.controller;

import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.models.Form.MedicoForm;
import com.seventeam.gsf.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/medico")
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
    	ResponseEntity<Medico> response = ResponseEntity.status(HttpStatus.FOUND).body(medico);
    	
    	return  response;
    }
	
	@RequestMapping(path = "/crm", method = RequestMethod.GET)
	public ResponseEntity<Medico> getByCrm(@RequestParam("crm") String crm)
	{
		if (UtilsString.isEmptyOrBlanck(crm)){
			// TODO: throw Invalid Paramns
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Medico());
		}
		
		Medico medico = medicoService.getByCrm(crm);
		ResponseEntity<Medico> response = ResponseEntity.status(HttpStatus.FOUND).body(medico);
		
		return  response;
	}
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Medico> create(@RequestBody MedicoForm form)
    {
	    medicoService.save(form);
	
	    ResponseEntity reponse = ResponseEntity.ok().body(form);
	    return reponse;
    
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Medico> update(@PathVariable Integer id, @RequestBody MedicoForm form)
	{
		medicoService.update(form, id);
		
		ResponseEntity reponse = ResponseEntity.status(HttpStatus.GONE).body(form);
		return reponse;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable Integer id)
	{
		medicoService.delete(id);
		
		ResponseEntity reponse = ResponseEntity.status(HttpStatus.GONE).build();
		return reponse;
	}

	@RequestMapping(value = "minhas_pacientes")
	public String minhasPacientes()
	{
		return "lista_gestante";
	}
	
}
