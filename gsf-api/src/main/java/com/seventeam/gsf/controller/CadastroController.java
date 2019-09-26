package com.seventeam.gsf.controller;
import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.services.PacienteService;
import com.seventeam.gsf.services.ProcedimentoService;
import com.seventeam.gsf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/cadastro")
public class CadastroController {

    @Autowired
    public UsuarioService usuarioService;
    @Autowired
    public ProcedimentoService procedimentoService;

    @Autowired
    public PacienteService pacienteService;

    @PostMapping("/savePaciente")
    public ModelAndView savePaciente(@ModelAttribute Paciente paciente) {
        ModelAndView mav = new ModelAndView("cadastro_gestante");
        try{
            pacienteService.save(paciente);
            mav.addObject("resposta", "Paciente cadastrada com sucesso");
        }catch(Exception ex){
            mav.addObject("resposta", "Ocorreu um erro ->" + ex.getMessage());
        }
        return mav;
    }

    @PostMapping("/updatePaciente")
    public ModelAndView updatePaciente(@ModelAttribute Paciente paciente) {
        ModelAndView mav = new ModelAndView("cadastro_gestante");
        try{
            pacienteService.save(paciente);
            mav.addObject("resposta", "Paciente atualizada com sucesso");
        }catch(Exception ex){
            mav.addObject("resposta", "Ocorreu um erro ->" + ex.getMessage());
        }
        return mav;
    }
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String Login(@RequestParam Map<String, String> allRequestParams){
        String user = allRequestParams.get("user");
        String pass = allRequestParams.get("password");
        String erro = allRequestParams.get("erro");     //DONT THROW exception. null value.

        return "Olá, Usuário!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login_paciente")
    public @ResponseBody String LoginPaciente(@RequestParam Map<String, String> allRequestParams){
        String user = allRequestParams.get("user");
        String pass = allRequestParams.get("password");
        String erro = allRequestParams.get("erro");     //DONT THROW exception. null value.

        return "Olá, Paciente!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login_medico")
    public @ResponseBody String LoginMedico(@RequestParam Map<String, String> allRequestParams){
        String user = allRequestParams.get("user");
        String pass = allRequestParams.get("password");
        String erro = allRequestParams.get("erro");     //DONT THROW exception. null value.

        return "login_medico";
    }

    @RequestMapping(value = "/gestante")
    public ModelAndView gestante() {
        ModelAndView mav = new ModelAndView("cadastro_gestante");
        mav.addObject("actionSalvarAtualizar", "/cadastro/savePaciente");
        return mav;
    }

    @RequestMapping(value = "/atualizar/gestante")
    public ModelAndView atualizarGestante(HttpSession httpSession) {
        String login = (String) httpSession.getAttribute("login");
        Paciente p = pacienteService.getByLogin(login);
        ModelAndView mav = new ModelAndView("cadastro_gestante");
        mav.addObject("actionSalvarAtualizar", "/cadastro/updatePaciente");
        mav.addObject("paciente", p);
        return mav;
    }

    @RequestMapping(value = "/medico")
    public String medico() {
        return "cadastro_medico";
    }

    @PostMapping("/exclui/paciente")
    public ModelAndView excluirPaciente(HttpSession session, @ModelAttribute Paciente p){

        try {
            pacienteService.delete(p.getId(), (String) session.getAttribute("login"));
            ModelAndView mav = new ModelAndView("redirect:/login/gestante");
            session.removeAttribute("login");
            return mav;
        }catch (Exception ex){
            ModelAndView mav = new ModelAndView("cadastro_gestante");
            mav.addObject("resposta", ex.getMessage());
            return mav;
        }

    }

}