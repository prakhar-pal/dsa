import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/

class Solution {
    private HashMap<HashMap<Integer,Integer>, Integer> ptMap;
    public Solution() {
        ptMap = new HashMap<>();
    }
    private int getPascValueMemoized(int row, int col){
        HashMap<Integer, Integer> key = new HashMap<>();
        key.put(row, col);
        if(ptMap.get(key) != null){
            return ptMap.get(key);
        }else {
            int value = getPascTriaValAt(row-1, col-1) + getPascTriaValAt(row-1, col);
            ptMap.put(key, value);
            return value;
        }
    }
    private int getPascTriaValAt(int row, int col){
        if(col == 0 || row == col) return 1;
        else return getPascValueMemoized(row, col);
    }
    public List<Integer> getRow(int rowIndex) {
        int N = rowIndex+1;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(getPascTriaValAt(rowIndex, i));
        }
        return list;
    }
}

class Choluson {
    private int getPascTriaValAt(int row, int col){
        if(col == 0 || row == col) return 1;
        else return getPascTriaValAt(row-1, col-1) + getPascTriaValAt(row-1, col);
    }
    public List<Integer> getRow(int rowIndex) {
        int N = rowIndex+1;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(getPascTriaValAt(rowIndex, i));
        }
        return list;
    }
}
public class Rec05PascalTriangle2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // use the Cholusion instance to observe the non memoized version
        // Choluson sol = new Choluson(); 
        List<Integer> list = sol.getRow(30);
        for(Integer i:list){
            System.out.print(i+"\t");
        }
        System.out.println();
    }   
}
