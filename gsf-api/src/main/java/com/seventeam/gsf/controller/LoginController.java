package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Procedimento;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.services.PacienteService;
import com.seventeam.gsf.services.ProcedimentoService;
import com.seventeam.gsf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    public UsuarioService usuarioService;
    @Autowired
    public ProcedimentoService procedimentoService;
    @Autowired
    public PacienteService pacienteService;

//    @RequestMapping(method = RequestMethod.GET)
//    public @ResponseBody String Login(@RequestParam Map<String, String> allRequestParams){
//        String user = allRequestParams.get("user");
//        String pass = allRequestParams.get("password");
//        String erro = allRequestParams.get("erro");     //DONT THROW exception. null value.
//
//        return "Olá, Usuário!";
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/login_paciente")
//    public @ResponseBody String LoginPaciente(@RequestParam Map<String, String> allRequestParams){
//        String user = allRequestParams.get("user");
//        String pass = allRequestParams.get("password");
//        String erro = allRequestParams.get("erro");     //DONT THROW exception. null value.
//
//        return "Olá, Paciente!";
//    }

//    @RequestMapping(method = RequestMethod.GET, value = "/login_medico")
//    public @ResponseBody String LoginMedico(@RequestParam Map<String, String> allRequestParams){
//        String user = allRequestParams.get("user");
//        String pass = allRequestParams.get("password");
//        String erro = allRequestParams.get("erro");     //DONT THROW exception. null value.
//
//        return "login_medico";
//    }

    @RequestMapping(value = "/gestante")
    public String gestante() {
        return "login_gestante";
    }

    @RequestMapping(value = "/medico")
    public String medico() {
        return "login_medico";
    }

    //    @RequestMapping("efetuaLogin")
//    public String efetuaLogin(Usuario usuario, HttpSession session) {
//        if(new UsuarioDao().existeUsuario(usuario)) {
//            session.setAttribute("usuarioLogado", usuario);
//            return "menu";
//        }
//        return "redirect:loginForm";
//    }
    // public @ResponseBody String Login(@RequestParam("user") String user, @RequestParam("password") String password)


//    OFICIAL
//    @RequestMapping(value = "/gestante")
//    public String login_gestante() {
//        return "login_gestante";
//    }
//
//    @RequestMapping(value = "/medico")
//    public String login_medico() {
//        return "login_medico";
//    }
//

    @PostMapping("/gestante")
    public ModelAndView doLogin(@ModelAttribute Usuario u) {
        Usuario db = usuarioService.findOne(u.getLogin(), u.getPassword());
        if (db != null) {
            List<Procedimento> listaProcedimentos = procedimentoService.findAll();
            ModelAndView mav = new ModelAndView("procedimentos");
            mav.addObject("listaProcedimentos", listaProcedimentos);

            return mav;
        } else {
            return null;
        }
    }

    @PostMapping("/medico")
    public ModelAndView doLoginMedico(@ModelAttribute Usuario u) {
        Usuario db = usuarioService.findOne(u.getLogin(), u.getPassword());
        if (db != null) {
            List<Paciente> listaPacientes = pacienteService.findAll();
            ModelAndView mav = new ModelAndView("lista_gestante");
            mav.addObject("listaPacientes", listaPacientes);

            return mav;
        }
        else {
            return null;
        }
    }
}