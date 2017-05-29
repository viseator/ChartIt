package com.viseator.chartit.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class DataCoverter {
    public static String floatsToString(List<Float> list) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(";;");
            }
        }
        return sb.toString();
    }
    public static String stringListToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(";;");
            }
        }
        return sb.toString();
    }

    public static List<Float> stringToFloats(String s) {
        List<Float> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, ";;", false);
        while (st.hasMoreTokens()) {
            result.add(Float.valueOf(st.nextToken()));
        }
        return result;
    }

    public static List<String> stringToStringList(String s) {
        List<String> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, ";;", false);
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        return result;
    }
}
