// https://leetcode.com/problems/zigzag-conversion/description/
class Solution {
    public String convert(String s, int numRows) {
        int slength = s.length();
        char result[] = new char[slength];
        int resultIndex = 0;
        if(numRows == 1) return s;
        for (int row = 0; row < numRows; row++) {
            if (row == 0 || row == numRows - 1) {
                int increment = 2*(numRows-1);
                int index = row;
                while(index < slength){
                    System.out.println("index="+index+", resultIndex="+resultIndex);
                    result[resultIndex] = s.charAt(index);
                    index += increment;
                    resultIndex++;
                }
            }else {
                int[] increment = {2*(numRows-row-1), 2*row};
                boolean toggle = true; // use first increment, else use the second;
                int index = row;
                while(index < slength){
                    result[resultIndex] = s.charAt(index);
                    index += toggle ? increment[0]: increment[1];
                    toggle = !toggle;
                    resultIndex++;
                } 
            }
        }
        // System.out.println(s+"'s result:"+String.valueOf(result));
        return String.valueOf(result);
    }
}

public class P2StrZigZag {
    public static void main(String[] args) {
        Solution sol = new Solution();
        assert sol.convert("PAYPALISHIRING", 1).equals("PAYPALISHIRING");
        assert sol.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR");
        assert sol.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI");
    }
}
