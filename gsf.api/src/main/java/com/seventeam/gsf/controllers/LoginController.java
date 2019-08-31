package com.seventeam.gsf.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController
{

    @RequestMapping(method = RequestMethod.GET)
    public String Login()
    {
        return "Olá, Usuário!";
    }
}
