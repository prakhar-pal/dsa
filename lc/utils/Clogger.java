package lc.utils;

import java.util.List;

public class Clogger {
    public static <T> void log(T object) {
        System.out.println(object);
    }
    public static void log() {
        System.out.println();
    }
    public static void lognl() {
        System.out.println();
    }
    public static <T> void logi(T object) {
        System.out.print(object);
    }
    public static void printf(String format, Object ... args) {
        System.out.format(format, args);
    }
    public static void logArray(String name, List<String> list) {
        Clogger.log("Printing: " + name);
        for(int i=0;i<list.size();i++) {
            Clogger.log(list.get(i));
                Clogger.log("\n");
        }
        Clogger.log("\n");
    }
    public static <T> void logArray(String name, T[][] arr, boolean useLinebreak) {
        Clogger.log("Printing: " + name);
        for(int i=0;i<arr.length;i++) {
            Clogger.log(arr[i].toString());
            if(useLinebreak) {
                Clogger.log("\n");
            }
        }
        Clogger.log("\n");
    }
}
