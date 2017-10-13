package com.viseator.chartit.utils;

/**
 * Created by viseator on 10/13/17.
 * Wu Di
 * viseator@gmail.com
 */

public class Utils {
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
