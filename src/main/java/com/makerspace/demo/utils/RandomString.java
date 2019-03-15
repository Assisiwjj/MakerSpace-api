package com.makerspace.demo.utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomString {
    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
}

    private static String string = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String getRandomString(int length){
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len-1)));
        }
        return sb.toString();
    }

}