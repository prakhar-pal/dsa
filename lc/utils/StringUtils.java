package lc.utils;

public class StringUtils {
    public static <T> String toString(T[] items) {
        StringBuilder result = new StringBuilder();
        for(T item: items) {
            result.append(item  + " ");
        }
        return result.toString().trim();
    }
    public static String toString(int[] items) {
        StringBuilder result = new StringBuilder();
        for (int item : items) {
            result.append(item).append(" ");
        }
        return result.toString().trim();
    }
}
