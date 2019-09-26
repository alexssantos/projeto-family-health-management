package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Procedimento;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.models.Form.PacienteForm;
import com.seventeam.gsf.models.dto.PacienteDto;
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
@RequestMapping(value = "/paciente")
public class PacienteController {

    @Autowired
    public UsuarioService usuarioService;
    @Autowired
    public ProcedimentoService procedimentoService;
    @Autowired
    public PacienteService pacienteService;

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
       // pacienteService.save(form);

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
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PacienteDto> delete(@PathVariable Integer id, @RequestBody PacienteForm form)
    {
        pacienteService.update(form, id);
    
        ResponseEntity reponse = ResponseEntity.status(HttpStatus.GONE).body(form);
        return reponse;
    }

    @RequestMapping(value = "/login")
    public String loginPaciente() {
        return "login_paciente";
    }

    @PostMapping("/login")
    public ModelAndView doLoginPaciente(@ModelAttribute Usuario u, HttpSession session) {
        Usuario db = usuarioService.findOne(u.getLogin(), u.getPassword());
        if (db != null) {
            session.setAttribute("login", db.getLogin());
            List<Procedimento> listaProcedimentos = procedimentoService.findAll();
            ModelAndView mav = new ModelAndView("procedimentos");
            mav.addObject("listaProcedimentos", listaProcedimentos);

            return mav;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/cadastrar")
    public ModelAndView cadastroPaciente() {
        ModelAndView mav = new ModelAndView("cadastro_paciente");
        mav.addObject("actionSalvarAtualizar", "/paciente/cadastrar");
        return mav;
    }

    @PostMapping("/cadastrar")
    public ModelAndView doCadastroPaciente(@ModelAttribute Paciente paciente) {
        ModelAndView mav = new ModelAndView("sucesso");
        try{
            pacienteService.save(paciente);
            mav.addObject("resposta", "Paciente cadastrada com sucesso");
        }catch(Exception ex){
            mav.addObject("resposta", "Ocorreu um erro ->" + ex.getMessage());
        }
        return mav;
    }
//    -------------------

    @PostMapping("/alterar")
    public ModelAndView updatePaciente(@ModelAttribute Paciente paciente) {
        ModelAndView mav = new ModelAndView("cadastro_paciente");
        try{
            pacienteService.save(paciente);
            mav.addObject("resposta", "Paciente atualizada com sucesso");
        }catch(Exception ex){
            mav.addObject("resposta", "Ocorreu um erro ->" + ex.getMessage());
        }
        return mav;
    }

    @RequestMapping(value = "/alterar")
    public ModelAndView atualizarPaciente(HttpSession httpSession) {
        String login = (String) httpSession.getAttribute("login");
        Paciente p = pacienteService.getByLogin(login);
        ModelAndView mav = new ModelAndView("cadastro_paciente");
        mav.addObject("actionSalvarAtualizar", "/paciente/cadastrar");
        mav.addObject("paciente", p);
        return mav;
    }

    @PostMapping(value = "/excluir")
    public ModelAndView excluir(HttpSession session, @ModelAttribute Paciente p){
        try {
            pacienteService.delete(p.getId(), (String) session.getAttribute("login"));
            ModelAndView mav = new ModelAndView("redirect:/paciente/login");
            session.removeAttribute("login");
            return mav;
        }
        catch (Exception ex){
            ModelAndView mav = new ModelAndView("cadastro_paciente");
            mav.addObject("resposta", ex.getMessage());
            return mav;
        }
    }
}