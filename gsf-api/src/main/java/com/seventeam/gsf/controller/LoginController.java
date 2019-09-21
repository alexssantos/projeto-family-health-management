package com.seventeam.gsf.controller;

import com.seventeam.gsf.domain.Medico;
import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.domain.Usuario;
import com.seventeam.gsf.repository.UsuarioDao;
import com.seventeam.gsf.services.UsuarioService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    public UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String Login(@RequestParam Map<String, String> allRequestParams){
        String user = allRequestParams.get("user");
        String pass = allRequestParams.get("password");
        String erro = allRequestParams.get("erro");     //DONT THROW exception. null value.

        return "Olá, Usuário!";
    }
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

//    @RequestMapping(value = "/login_medico")
//    public String medico() {
//        return "login_medico";
//    }

    //    @RequestMapping("efetuaLogin")
//    public String efetuaLogin(Usuario usuario, HttpSession session) {
//        if(new UsuarioDao().existeUsuario(usuario)) {
//            session.setAttribute("usuarioLogado", usuario);
//            return "menu";
//        }
//        return "redirect:loginForm";
//    }
    // public @ResponseBody String Login(@RequestParam("user") String user, @RequestParam("password") String password)

    @RequestMapping(value = "/gestante")
    public String login_gestante() {
        return "login_gestante";
    }

    @RequestMapping(value = "/medico")
    public String login_medico() {
        return "login_medico";
    }

    @PostMapping("/gestante")
    public String doLogin(@ModelAttribute Usuario u){
        Usuario db = usuarioService.findOne(u.getLogin(), u.getPassword());

        if (db != null) {
            return "procedimentos";
        }
        else {
            return "login_gestante";
        }
    }
//    @RequestMapping(method = RequestMethod.POST)
//    public String submit(Model model, @ModelAttribute("usuario") Usuario usuario) {
//        if (usuario != null && usuario.getLogin() != null & usuario.getPassword() != null) {
//            if (usuario.getLogin().equals("chandra") && usuario.getPassword().equals("chandra123")) {
//                model.addAttribute("msg", usuario.getLogin());
//                return "success";
//            } else {
//                model.addAttribute("error", "Invalid Details");
//                return "procedimentos";
//            }
//        } else {
//            model.addAttribute("error", "Please enter Details");
//            return "error";
//        }
//    }
}
