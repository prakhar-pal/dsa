package lc.BinarySearch;
import java.util.Arrays;
class SolutionC07KthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int totalNums = nums.length;
        int pairs = totalNums*(totalNums-1)/2;
        int diffs[] = new int[pairs];
        int c = 0;
        for(int i=0;i<totalNums;i++){
            for(int j=i+1;j<totalNums;j++){
                diffs[c++] = Math.abs(nums[i] - nums[j]);
            }
                
        }
        Arrays.sort(diffs);
        return diffs[k-1];
    }
}

class B17KthSmallestPairDistance {
    public static void main(String[] args){
        SolutionC07KthSmallestPairDistance sol = new SolutionC07KthSmallestPairDistance();

        int arr1[] = {1,3,1};
        int k1 = 1;
        int arr2[] = {1,1,1};
        int k2 = 2;
        int arr3[] = {1,6,1};
        int k3 = 3;

        assert sol.smallestDistancePair(arr1, k1) == 0;
        assert sol.smallestDistancePair(arr2, k2) == 0;
        assert sol.smallestDistancePair(arr3, k3) == 5;
    }
}
