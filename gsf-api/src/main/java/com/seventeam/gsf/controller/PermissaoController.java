package com.seventeam.gsf.controller;

import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.domain.Permissao;
import com.seventeam.gsf.models.Form.PermissaoForm;
import com.seventeam.gsf.services.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/permissao")
public class PermissaoController {


	@Autowired
	PermissaoService permissaoService;

	@RequestMapping(path = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<Permissao>> getAll()
	{
		List<Permissao> permissaoList = permissaoService.findAll();
		ResponseEntity<List<Permissao>> response = ResponseEntity.ok().body(permissaoList);
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Permissao> getById(@PathVariable Integer id)
	{
		if (id > 0){
			// TODO: throw Invalid Paramns
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		Permissao obj = permissaoService.findById(id);
		ResponseEntity<Permissao> response = ResponseEntity.status(HttpStatus.FOUND).body(obj);

		return  response;
	}

	@RequestMapping(path = "/perfil", method = RequestMethod.GET)
	public ResponseEntity<List<Permissao>> getByPerfil(@RequestParam("tipo") String perfilStr)
	{
		if (UtilsString.isEmptyOrBlanck(perfilStr)){
			// TODO: throw Invalid Paramns
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		List<Permissao> permissao = permissaoService.getByPerfil(perfilStr);
		ResponseEntity<List<Permissao>> response = ResponseEntity.status(HttpStatus.FOUND).body(permissao);

		return  response;
	}


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Medico> create(@RequestBody PermissaoForm form)
    {
        //permissaoService.save(form);

        ResponseEntity reponse = ResponseEntity.ok().body(form);
        return reponse;

    }

    
    /*
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Medico> update(@PathVariable Integer id, @RequestBody MedicoForm form)
    {
        permissaoService.update(form, id);

        ResponseEntity reponse = ResponseEntity.status(HttpStatus.GONE).body(form);
        return reponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id)
    {
        permissaoService.delete(id);

        ResponseEntity reponse = ResponseEntity.status(HttpStatus.GONE).build();
        return reponse;
    }

 */
}
