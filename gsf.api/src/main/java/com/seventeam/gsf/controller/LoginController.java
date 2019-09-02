package com.seventeam.gsf.controller;

import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController
{

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String Login(@RequestParam Map<String, String> allRequestParams){
        String user = allRequestParams.get("user");
        String pass = allRequestParams.get("password");
        String erro = allRequestParams.get("erro");     //DONT THROW exception. null value.

        return "Olá, Usuário!";
    }

    // public @ResponseBody String Login(@RequestParam("user") String user, @RequestParam("password") String password)
}
