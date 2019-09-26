//package com.seventeam.gsf.controller;
//
//import com.seventeam.gsf.domain.Paciente;
//import com.seventeam.gsf.domain.Procedimento;
//import com.seventeam.gsf.domain.Usuario;
//import com.seventeam.gsf.models.enums.PerfilTipoEnum;
//import com.seventeam.gsf.repository.UsuarioDao;
//import com.seventeam.gsf.services.PacienteService;
//import com.seventeam.gsf.services.ProcedimentoService;
//import com.seventeam.gsf.services.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping(value = "/login")
//public class LoginController {
//
//    @Autowired
//    public UsuarioService usuarioService;
//    @Autowired
//    public ProcedimentoService procedimentoService;
//    @Autowired
//    public PacienteService pacienteService;
//
//
//
//    //
////    @RequestMapping(value = "/medico")
////    public String medico() {
////        return "login_medico";
////    }
//
////    @PostMapping("/medico")
////    public ModelAndView doLoginMedico(@ModelAttribute Usuario u, HttpSession session) {
////        Usuario db = usuarioService.findOne(u.getLogin(), u.getPassword());
////
////        if (db != null) {
////            if(db.getPerfil().getTipoPerfil().equals(PerfilTipoEnum.PACIENTE)){
////                ModelAndView mav = new ModelAndView("redirect:/login/paciente");
////                return mav;
////            }
////
////            session.setAttribute("login", u.getLogin());
////            List<Paciente> listaPacientes = pacienteService.findAll();
////            ModelAndView mav = new ModelAndView("lista_paciente");
////            return mav;
////        }
////        else {
////            return null;
////        }
////    }
////     public @ResponseBody String Login(@RequestParam("user") String user, @RequestParam("password") String password);
//
//}