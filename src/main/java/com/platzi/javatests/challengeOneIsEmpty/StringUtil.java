package com.platzi.javatests.challengeOneIsEmpty;

public class StringUtil {

    public static boolean isEmpty(String cadena){
        return cadena == null || cadena.trim().equals("");
    }
}
