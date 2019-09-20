package com.seventeam.gsf.controller;


import com.seventeam.gsf.domain.Permissao;
import com.seventeam.gsf.services.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    PermissaoService permissaoService;

    @GetMapping()
    public ResponseEntity<List<Permissao>> get()
    {
        List<Permissao> permissaoList = permissaoService.findAll();


        ResponseEntity<List<Permissao>> response = ResponseEntity.ok().body(permissaoList);
        return response;
    }
}
