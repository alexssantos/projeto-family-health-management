package com.seventeam.gsf.Utils;

import java.text.MessageFormat;

public class UtilsString {

    public static String msgFormat(String s, Object... args) {
        return new MessageFormat(s).format(args);
    }

    public static String formatNumberFixedLenght(int number, int lenght){
        String value = Integer.toString(number);

        if (!value.isEmpty() && value.length() < lenght)
        {
            int diff = lenght - value.length();
            String zerosStr = "0".repeat(diff);

            value = zerosStr+value;
        }
        return value;
    }
    
    public static boolean isEmptyOrBlanck(String value)
    {
        if (value.isBlank() || value.isEmpty())
        {
            return true;
        }
        return false;
    }
}


