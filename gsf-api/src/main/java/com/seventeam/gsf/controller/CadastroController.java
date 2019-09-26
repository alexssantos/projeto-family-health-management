package com.seventeam.gsf.controller;
import com.seventeam.gsf.domain.Paciente;
import com.seventeam.gsf.services.PacienteService;
import com.seventeam.gsf.services.ProcedimentoService;
import com.seventeam.gsf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/medico")
    public String medico() {
        return "cadastro_medico";
    }
}