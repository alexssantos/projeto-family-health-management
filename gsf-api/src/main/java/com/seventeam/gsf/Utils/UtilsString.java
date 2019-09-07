package com.seventeam.gsf.Utils;

import java.text.MessageFormat;

public class UtilsString {

    public static String msgFormat(String s, Object... args) {
        return new MessageFormat(s).format(args);
    }
}


