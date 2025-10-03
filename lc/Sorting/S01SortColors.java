package lc.Sorting;
import lc.utils.ArrayUtils;
// https://leetcode.com/problems/sort-colors/description/
class SolutionP0SortColors {
    public void sortColors(int[] nums) {
        this.sortColors(nums);
    }
    public int[] sortColors2(int[] nums) {
        int[] counts = {0,0,0};
        for(int num:nums){
            counts[num]++;
        }
        int index = 0;
        for(int i=0;i<counts[0];i++, index++){
            nums[index] = 0;
        }
        for(int i=0;i<counts[1];i++, index++){
            nums[index] = 1;
        }
        for(int i=0;i<counts[2];i++, index++){
            nums[index] = 2;
        }
        return nums;
    }
}

public class S01SortColors {

    public static void main(String[] args) {
        SolutionP0SortColors sol = new SolutionP0SortColors();
        int[][] example1 = {
            {2,0,2,1,1,0},
            {0,0,1,1,2,2}
        };
        int[][] example2 = {
            {2,0,1},
            {0,1,2}
        };
        int[][] example3 = {
            {2,1},
            {1,2}
        };
        int[][] example4 = {
            {1,2},
            {1,2}
        };
        int[][] example5 = {
            {1,2},
            {1,2}
        };
        assert ArrayUtils.isSame1DArray(sol.sortColors2(example1[0]), example1[1]);
        assert ArrayUtils.isSame1DArray(sol.sortColors2(example2[0]), example2[1]);
        assert ArrayUtils.isSame1DArray(sol.sortColors2(example3[0]), example3[1]);
        assert ArrayUtils.isSame1DArray(sol.sortColors2(example4[0]), example4[1]);
        assert ArrayUtils.isSame1DArray(sol.sortColors2(example5[0]), example5[1]);
    }
}
