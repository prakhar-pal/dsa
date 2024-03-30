import java.util.*;
// https://leetcode.com/problems/3sum/
/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

 * Notice that the solution set must not contain duplicate triplets.
 * Constraints:
 *   3 <= nums.length <= 3000
 *  -105 <= nums[i] <= 105
 */

 interface Solution {
    public List<List<Integer>> threeSum(int[] nums);
 }

class Solution3Sum implements Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        System.out.println("info:threeSum.");
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> numMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(numMap.containsKey(num)) {
                numMap.get(num).add(i);
            } else {
                ArrayList<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                numMap.put(num, indexList);
            }
        }
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                int remaining = 0 - nums[i] - nums[j];
                if(numMap.containsKey(remaining)) {
                    ArrayList<Integer> indexList = numMap.get(remaining);
                    int suitableIndex = -1;
                    for(int k=0;k<indexList.size();k++) {
                        int index = indexList.get(k);
                        if(i >= index || j >= index) {
                            continue;
                        } else {
                            suitableIndex = index;
                            break;
                        }
                    }
                    if(suitableIndex != -1) {
                        List<Integer> triplets = new ArrayList<>();
                        triplets.add(nums[i]);
                        triplets.add(nums[j]);
                        triplets.add(nums[suitableIndex]);
                        list.add(triplets);
                    }
                }
                while((j + 1) < nums.length && nums[j+1] == nums[j]) {
                    j++;
                }
            }
            while((i + 1) < nums.length && nums[i+1] == nums[i]) {
                i++;
            }
        }
        return list;
    }
}

class Solution100Pc implements Solution {
    // solution from leetcode which passes and  beats 100% of other submissions
    private List<List<Integer>> res;
    public List<List<Integer>> threeSum(int[] nums) {
        return new AbstractList<List<Integer>>() {
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }
            public int size() {
                init();
                return res.size();
            }
            private void init() {
                if (res != null) return;
                Arrays.sort(nums);
                int l, r, sum;
                Set<List<Integer>> tempRes = new HashSet<>();
                for(int i = 0; i < nums.length - 2; ++i) {
                    l = i + 1;
                    r = nums.length - 1;
                    while(l < r) {
                        sum = nums[i] + nums[l] + nums[r];
                        if (sum == 0) tempRes.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        if (sum < 0) ++l; else --r;
                    }
                }
                res = new ArrayList<List<Integer>>(tempRes);
            }
            
        };
    }
}


class P23Sum {

    public static boolean threeSumEquals(List<List<Integer>> list1, int [][] arr2) {
        System.out.println("info:checking array equality.");
        if(list1.size() != arr2.length) {
            System.out.println("err:outer array size is different -> list1=" + list1.size() + ", and arr2=" + arr2.length);
            return false;
        }
        for(int i=0;i<list1.size();i++) {
            List<Integer> list11 = list1.get(i);
            int[] arr22 = arr2[i];
            if(list11.size() != arr22.length) {
                System.out.println("err:inner array size is different");
                return false;
            }
            for(int j=0;j<list11.size();j++) {
                if(list11.get(j) != arr22[j]) {
                    System.out.println("err:inner array -> expected=" + arr22[j] + ", got=" + list11.get(j));
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        Solution sol = new SolutionTutCup();

        int[] input1 = {-1,0,1,2,-1,-4};
        int[][] output1 = {{-1,-1,2},{-1,0,1}};
        List<List<Integer>> result1 = sol.threeSum(input1);
        assert threeSumEquals(result1, output1);

        int[] input2 = {0,1,1};
        int[][] output2 = {};
        List<List<Integer>> result2 = sol.threeSum(input2);
        assert threeSumEquals(result2, output2);

        int[] input3 = {0,0,0,0};
        int[][] output3 = {{0,0,0}};
        List<List<Integer>> result3 = sol.threeSum(input3);
        assert threeSumEquals(result3, output3);
    }    
}
