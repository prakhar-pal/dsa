package lc.ArraysAndStrings;
import java.util.*;

public class ArrayUtils {
    public static <T> boolean isSame1DArray(T[] arr1, T[] arr2) {
        if(arr1.length != arr2.length) {
            return false;
        }
        for(int i=0;i<arr1.length;i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] convert(int[] arr) {
        Integer[] copy = new Integer[arr.length];
        for(int i=0;i<arr.length;i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static boolean isSame1DArray(int[] arr1, int[] arr2) {
        return isSame1DArray(convert(arr1), convert(arr2));
    }

    public static <T> T[] listToArray(List<T> list) {
        T[] array = (T[]) list.toArray();
        return array;
    }

    public static <T> List<T> arrayToList(T[] arr) {
        return Arrays.asList(arr);
    }
}
