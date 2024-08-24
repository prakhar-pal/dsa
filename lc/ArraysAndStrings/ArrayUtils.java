package lc.ArraysAndStrings;
import java.util.*;

public class ArrayUtils {
    public static <T> boolean isSame1DArray(T[] arr1, T[] arr2) {
        if(arr1.length != arr2.length) {
            return false;
        }
        for(int i=0;i<arr1.length;i++) {
            if(!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSame2DArray(char[][] arr1, char[][] arr2) {
        if(arr1.length != arr2.length) {
            return false;
        }
        if(arr1[0].length != arr2[0].length) {
            return false;
        }
        int m = arr1.length, n = arr1[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSame2DArray(int[][] arr1, int[][] arr2) {
        if(arr1.length != arr2.length) {
            return false;
        }
        if(arr1[0].length != arr2[0].length) {
            return false;
        }
        int m = arr1.length, n = arr1[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(arr1[i][j] != arr2[i][j]) {
                    return false;
                }
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

    public static <T> List<List<T>> createList(T[][] arr) {
        List<List<T>> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            List<T> row = new ArrayList<>();
            for(int j=0;j<arr[i].length;j++) {
                row.add(arr[i][j]);
            }
            list.add(row);
        }
        return list;
    }
}
