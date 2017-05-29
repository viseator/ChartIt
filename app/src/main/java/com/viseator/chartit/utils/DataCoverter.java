package com.viseator.chartit.utils;

import java.util.List;

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
    public static String stringsToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(";;");
            }
        }
        return sb.toString();
    }

}
