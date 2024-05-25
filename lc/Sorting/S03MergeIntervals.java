// https://leetcode.com/problems/merge-intervals/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Range {
    public int start, end;
    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class SolutionP3MergeIntervals2 {
    // https://leetcode.com/problems/merge-intervals/solutions/4893229/easy-java-solution-beats-100-sorting/
    public int[][] merge(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr,(a,b)->(a[0]-b[0]));
        ArrayList<int[]> a = new ArrayList<>();
        a.add(arr[0]);
        for(int i=1; i<n; i++){
            int x[] = a.get(a.size()-1);
            if(arr[i][0]>x[1]){
                a.add(arr[i]);
            }else{
                a.get(a.size()-1)[1] = Math.max(x[1],arr[i][1]);
            }
        }
        int ans[][] = new int[a.size()][2];
        for(int i=0; i<a.size(); i++){
            ans[i] = a.get(i);
        }
        return ans;
    }
}

class SolutionP3MergeIntervals {
    // beats 88.05% users with Java
    int MAX_SIZE = (int)Math.pow(10, 4) + 1;
    public int[][] merge(int[][] intervals) {
        int[] markers = new int[MAX_SIZE];
        Arrays.fill(markers, -1);
        ArrayList<Range> mergedList = new ArrayList<>();
        HashSet<Integer> rangeToDelete = new HashSet<>();
        for(int[] interval: intervals) {
            boolean hasSharedInterval = false;
            int sharedIntervalIndex = -1;
            for(int i=interval[0];i<=interval[1];i++){
                if(markers[i] != -1){
                    hasSharedInterval = true;
                    sharedIntervalIndex = markers[i];
                    break;
                }
            }
            if(!hasSharedInterval) {
                int mergedListSize = mergedList.size();
                for(int i=interval[0];i<=interval[1];i++){
                    markers[i] = mergedListSize;
                }
                mergedList.add(new Range(interval[0], interval[1]));
            } else {
                HashSet<Integer> newRangeToDelete = new HashSet<>();
                Range r = mergedList.get(sharedIntervalIndex);
                r.start = Math.min(r.start, interval[0]);
                r.end = Math.max(r.end, interval[1]);
                for(int i=r.start;i<=r.end;i++){
                    if(markers[i] != -1 && markers[i] != sharedIntervalIndex) {
                        newRangeToDelete.add(markers[i]);
                        Range tempr = mergedList.get(markers[i]);
                        r.end = Math.max(r.end, tempr.end);
                    }
                    markers[i] = sharedIntervalIndex;
                }
                for(int nrtdIndex: newRangeToDelete){
                    rangeToDelete.add(nrtdIndex);
                }
                // Collections.addAll(rangeToDelete, newRangeToDelete);
            }
        }
        ArrayList<Range> finalMergeList = new ArrayList<>();
        for(int i=0;i<mergedList.size();i++){
            if(!rangeToDelete.contains(i)) {
                finalMergeList.add(mergedList.get(i));
            }
        }
        int result[][] = new int[finalMergeList.size()][2];
        for(int i=0;i<finalMergeList.size();i++){
            Range r = finalMergeList.get(i);
            result[i][0] = r.start;
            result[i][1] = r.end;
        }
        return result;
    }
}
public class S03MergeIntervals {

    public static boolean isSameArray(int[][] arr1, int[][] arr2) {
        if(arr1.length != arr2.length) {
            System.out.println("err:array of different sizes: len(arr1)=" + arr1.length + ", len(arr2)="+arr2.length);
            return false;
        }
        for(int i=0;i<arr1.length;i++) {
            if(arr1[i][0] != arr2[i][0] || arr1[i][1] != arr2[i][1]) {
                System.out.println("expected " + arr1[i][0] + ", got " + arr2[i][0]);
                System.out.println("expected " + arr1[i][1] + ", got " + arr2[i][1]);
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        SolutionP3MergeIntervals sol = new SolutionP3MergeIntervals();

        int[][][] case1 = {
            {{1,3},{2,6},{8,10},{15,18}},
            {{1,6},{8,10},{15,18}}
        };
        assert isSameArray(sol.merge(case1[0]), case1[1]);

        int[][][] case2 = {
            {{1,4},{4,5}},
            {{1,5}}
        };
        assert isSameArray(sol.merge(case2[0]), case2[1]);

        int[][][] case3 = {
            {{1,4},{0,1}},
            {{0,4}}
        };
        assert isSameArray(sol.merge(case3[0]), case3[1]);

        int[][][] case4 = {
            {{4,5},{1,4},{0,1}},
            {{0,5}}
        };
        assert isSameArray(sol.merge(case4[0]), case4[1]);

        int[][][] case5 = {
            {{2,3},{4,5},{6,7},{8,9},{1,10}},
            {{1,10}}
        };
        assert isSameArray(sol.merge(case5[0]), case5[1]);
    }
}
