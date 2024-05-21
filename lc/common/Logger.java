package lc.common;

import java.util.List;

public class Logger {
    public static <T> void log(T object) {
        System.out.println(object);
    }
    public static <T> void logi(T object) {
        System.out.print(object);
    }
    public static void printf(String format, Object ... args) {
        System.out.format(format, args);
    }
    public static void logArray(String name, List<String> list) {
        Logger.log("Printing: " + name);
        for(int i=0;i<list.size();i++) {
            Logger.log(list.get(i));
                Logger.log("\n");
        }
        Logger.log("\n");
    }
    public static <T> void logArray(String name, T[][] arr, boolean useLinebreak) {
        Logger.log("Printing: " + name);
        for(int i=0;i<arr.length;i++) {
            Logger.log(arr[i]);
            if(useLinebreak) {
                Logger.log("\n");
            }
        }
        Logger.log("\n");
    }
}
