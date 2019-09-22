package com.seventeam.gsf.controller;

import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.controller.validate.ValidateForms;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class LoginController
{
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String Login(){
        
        return "Olá, Usuário!";
    }
    

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String Login(@RequestParam Map<String, String> Params){
        
        //validate Login Parans ->
        if (!ValidateForms.validateLogin(Params)){
            return "VACILO";
        }
        String user = Params.get("user");
        String pass = Params.get("password");
        String tipoPerfil = Params.get("perfil");
    
        String reponseStr = UtilsString.msgFormat("LOGADO. \nOlá, '{0}'! \n{0}\t{1}\t{2}", user, pass,tipoPerfil);
        return reponseStr;
    }

    // public @ResponseBody String Login(@RequestParam("user") String user, @RequestParam("password") String password)
}
