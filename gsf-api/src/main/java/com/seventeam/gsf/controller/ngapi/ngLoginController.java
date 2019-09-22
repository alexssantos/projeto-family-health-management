package com.seventeam.gsf.controller.ngapi;


import com.seventeam.gsf.Utils.UtilsString;
import com.seventeam.gsf.controller.validate.ValidateForms;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/ngapi/login")
public class ngLoginController {
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	String Login(@RequestParam Map<String, String> Params){
		
		//validate Login Parans ->
		if (!ValidateForms.validateLogin(Params)){
			return "VACILO";
		}
		String user = Params.get("user");
		String pass = Params.get("password");
		String tipoPerfil = Params.get("perfil");
		
		String reponseStr = UtilsString.msgFormat("LOGADO. \nOlá, '{0}'! \n\n{1}", user,Params.values());
		return reponseStr;
	}
}

