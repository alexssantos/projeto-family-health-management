package com.seventeam.gsf.controller;

import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController
{

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String Login(@RequestParam("user") String user,
                                      @RequestParam("password") String password
    ){
        String params = user;
        String pass = password;

        return "Olá, Usuário!";
    }
}
