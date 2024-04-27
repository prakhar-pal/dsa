package lc.ArraysAndStrings;
import java.util.*;

public class ArrayUtils {
    public static boolean isSame1DArray(int[] arr1, int[] arr2) {
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

    public static  int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static <T> List<T> arrayToList(T[] arr) {
        List<T> list = new ArrayList<>();
        for(T item: arr) {
            list.add(item);
        }
        return list;
    }
}
