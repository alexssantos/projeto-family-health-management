package com.seventeam.gsf.controller.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL
{

    public static SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("dd/MM/yyyy");
    public static TimeZone ZONE_DEFAULT = TimeZone.getTimeZone("GMT-03:00");

    public static String decodeParam(String text)
    {
        try
        {
            return URLDecoder.decode(text, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public static Date convertDate(String textDate, Date defaultValue)
    {
        if (SDF_DATETIME.getTimeZone() != ZONE_DEFAULT)
        {
            SDF_DATETIME.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));
        }

        try
        {
            return SDF_DATETIME.parse(textDate);
        }
        catch (ParseException e)
        {
            return defaultValue;
        }

    }
}
