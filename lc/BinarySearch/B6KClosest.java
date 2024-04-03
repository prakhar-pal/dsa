// https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945/
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class SolutionB6KClosest {
    public int closer(int[] arr, int x, int index1, int index2){
        int diff1 = Math.abs(arr[index1] - x);
        int diff2 = Math.abs(arr[index2] - x);
        if(diff1 != diff2){
            if(diff1 > diff2) return index2;
            return index1;
        }else return index1;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();
        int low = 0, high = arr.length - 1;
        while(high >= low){
              int mid = low + (high-low)/2;
              int closerIndex = closer(arr, x, low, high);
              if(closerIndex == low) {
                  high = mid - 1;
              }else {
                  low = mid + 1;
              }
        }
        list.add(arr[low]);

        System.out.println("index is:"+low+" "+high);

        // build the list
        int left = low - 1, right = low + 1;
        while(list.size() != k){
            System.out.println("left :"+left+"\tright :"+right);
            if(left>=0 && right <= arr.length - 1){
                int ci = closer(arr, x, left, right);
                list.add(arr[ci]);
                if(ci == low) left--;
                else right++;
            }else if(left<0){
                list.add(arr[right]);
                right++;
            }else {
                list.add(arr[left]);
                left--;
            }
        }
        Collections.sort(list);
        return list;
    }
}

class B6KClosest {
    public static void printAns(List<Integer> ans){
        for(int num: ans){
            System.out.print(num + " \t");
        }
        System.out.println();
    }
    public static void main(String[] args){
        // tc 1
        int[] arr1 = {1,2,3,4,5};
        int k1 = 4, x1 = 3;

        // tc 2
        int[] arr2 = {1,2,3,4,5};
        int k2 = 4, x2 = -1;


        // tc 2
        int[] arr3 = {-2,-1,1,2,3,4,5};
        int k3 = 7, x3 = 3;

        SolutionB6KClosest sol = new SolutionB6KClosest();

        List<Integer> ans1 = sol.findClosestElements(arr1, k1, x1);
        List<Integer> ans2 = sol.findClosestElements(arr2, k2, x2);
        // printAns(ans1);
        // printAns(ans2);
        printAns(sol.findClosestElements(arr3, k3, x3));
    }
}
