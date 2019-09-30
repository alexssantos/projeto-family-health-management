package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Procedimento;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.models.Form.MedicoForm;
import com.seventeam.gsf.models.dto.MedicoDto;
import com.seventeam.gsf.services.MedicoService;
import com.seventeam.gsf.services.PacienteService;
import com.seventeam.gsf.services.ProcedimentoService;
import com.seventeam.gsf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/medico")
public class MedicoController {

	@Autowired
	public UsuarioService usuarioService;
	@Autowired
	public ProcedimentoService procedimentoService;
	@Autowired
	public MedicoService medicoService;
	@Autowired
	public PacienteService pacienteService;

	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<Medico>> get()
	{
		return getAll();
	}

	@RequestMapping(path = "/getall", method= RequestMethod.GET)
	public ResponseEntity<List<Medico>> getAll()
	{
		List<Medico> list = medicoService.findAll();
		List<MedicoDto> responseList = list.stream()
				.map(item -> new MedicoDto(item))
				.collect(Collectors.toList());

		ResponseEntity reponse = ResponseEntity.ok().body(responseList);
		return reponse;
	}


	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity createMedico(@RequestBody MedicoForm form)
	{
		//ValidateForm
		// medicoService.save(form);

		ResponseEntity reponse = ResponseEntity.ok().body(form);
		return reponse;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MedicoDto> findById(@PathVariable Integer id)
	{
		Medico obj = medicoService.findById(id);

		ResponseEntity reponse = ResponseEntity.ok().body(new MedicoDto(obj));
		return reponse;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<MedicoDto> delete(@PathVariable Integer id, @RequestBody MedicoForm form)
	{
		medicoService.update(form, id);

		ResponseEntity reponse = ResponseEntity.status(HttpStatus.GONE).body(form);
		return reponse;
	}

	@RequestMapping(value = "/login")
	public String loginMedico() {
		return "login_medico";
	}

	@PostMapping("/login")
	public ModelAndView doLoginMedico(@ModelAttribute Usuario u, HttpSession session) {
		Usuario db = usuarioService.findOne(u.getLogin(), u.getPassword());
		if (db != null) {
			session.setAttribute("login", db.getLogin());
			List<Paciente> listaPacientes = pacienteService.findAll();
			ModelAndView mav = new ModelAndView("lista_paciente");
			mav.addObject("listaPacientes", listaPacientes);
			return mav;
		} else {

			return null;
		}
	}

	@RequestMapping(value = "/cadastrar")
	public ModelAndView cadastroMedico() {
		ModelAndView mav = new ModelAndView("cadastro_medico");
		mav.addObject("actionSalvarAtualizar", "/medico/cadastrar");
		return mav;
	}

	@PostMapping("/cadastrar")
	public ModelAndView doCadastroMedico(@ModelAttribute Medico medico) {
		ModelAndView mav = new ModelAndView("sucesso");
		try{
			medicoService.save(medico);
			mav.addObject("resposta", "Medico cadastrada com sucesso");
		}catch(Exception ex){
			mav.addObject("resposta", "Ocorreu um erro ->" + ex.getMessage());
		}
		return mav;
	}

	@RequestMapping(value = "/alterar")
	public ModelAndView atualizarMedico(HttpSession httpSession) {
		String login = (String) httpSession.getAttribute("login");
		Medico p = medicoService.getByLogin(login);
		ModelAndView mav = new ModelAndView("cadastro_medico");
		mav.addObject("actionSalvarAtualizar", "/medico/cadastrar");
		mav.addObject("medico", p);
		return mav;
	}

//	@PostMapping(value = "/excluir")
//	public ModelAndView excluir(HttpSession session, @ModelAttribute Medico p){
//		try {
//			medicoService.delete(p.getId(), (String) session.getAttribute("login"));
//			ModelAndView mav = new ModelAndView("redirect:/");
//			session.removeAttribute("login");
//			return mav;
//		}
//		catch (Exception ex){
//			ModelAndView mav = new ModelAndView("cadastro_medico");
//			mav.addObject("resposta", ex.getMessage());
//			return mav;
//		}
//	}
}