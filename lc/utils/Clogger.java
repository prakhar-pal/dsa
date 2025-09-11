package lc.utils;

import java.util.Arrays;
import java.util.List;

public class Clogger {
    public static <T> void log(T object) {
        System.out.println(object);
    }

    public static void lognl() {
        System.out.println();
    }

    public static <T> void logi(T object) {
        System.out.print(object);
    }

    public static void printf(String format, Object... args) {
        System.out.format(format, args);
    }

    public static void logArray(String name, List<String> list) {
        Clogger.log("Printing: " + name);
        for (int i = 0; i < list.size(); i++) {
            Clogger.log(list.get(i));
            Clogger.log("\n");
        }
        Clogger.log("\n");
    }

    public static <T> void logArray(String name, T[][] arr, boolean useLinebreak) {
        Clogger.log("Printing: " + name);
        for (int i = 0; i < arr.length; i++) {
            Clogger.log(arr[i].toString());
            if (useLinebreak) {
                Clogger.log("\n");
            }
        }
        Clogger.log("\n");
    }

    public static void log(Object... args) {
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];

            if (arg != null && arg.getClass().isArray()) {
                // Convert arrays to a readable string
                if (arg instanceof int[])
                    System.out.print(Arrays.toString((int[]) arg));
                else if (arg instanceof long[])
                    System.out.print(Arrays.toString((long[]) arg));
                else if (arg instanceof double[])
                    System.out.print(Arrays.toString((double[]) arg));
                else if (arg instanceof char[])
                    System.out.print(Arrays.toString((char[]) arg));
                else if (arg instanceof boolean[])
                    System.out.print(Arrays.toString((boolean[]) arg));
                else
                    System.out.print(Arrays.deepToString((Object[]) arg));
            } else {
                System.out.print(arg);
            }

            if (i < args.length - 1) {
                System.out.print(" "); // space between args
            }
        }
        System.out.println(); // newline at the end
    }
}
