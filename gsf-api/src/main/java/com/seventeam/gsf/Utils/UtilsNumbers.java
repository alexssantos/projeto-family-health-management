package com.seventeam.gsf.Utils;

public class UtilsNumbers {


    public static int getRandomIntegerBetweenRange(double min, double max){
        return (int)((Math.random()*((max-min)+1))+min);
    }
}
