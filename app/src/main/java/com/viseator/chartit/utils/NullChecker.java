package com.viseator.chartit.utils;

/**
 * Created by viseator on 6/1/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class NullChecker {
    public static boolean isSetted(float a) {
        return a != 0f;
    }

    public static boolean isSetted(int a) {
        return a != 0;
    }

    public static boolean isSetted(Boolean a) {
        return a != null;
    }

    public static boolean isSetted(String a) {
        return a != null;
    }
}
