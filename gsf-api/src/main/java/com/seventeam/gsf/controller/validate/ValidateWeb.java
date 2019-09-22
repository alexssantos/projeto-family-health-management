package com.seventeam.gsf.controller.validate;

import com.seventeam.gsf.Utils.UtilsString;

import java.util.Map;
import java.util.Set;

public class ValidateWeb {
	
	public static boolean validateLogin(Map<String, String> Params)
	{
		Set<String> keys = Params.keySet();
		
		for (String key: keys) {
			if (UtilsString.isEmptyOrBlanck(Params.get(key)))
			{
				return false;
			}
		}
		return true;
	}
	
	
}
