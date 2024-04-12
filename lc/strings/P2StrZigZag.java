package lc.strings;
// https://leetcode.com/problems/zigzag-conversion/description/
class SolutionP2StrZigZag {
    public String convert(String s, int numRows) {
        int slength = s.length();
        char result[] = new char[slength];
        int resultIndex = 0;
        if (numRows == 1)
            return s;
        for (int row = 0; row < numRows; row++) {
            if (row == 0 || row == numRows - 1) {
                int increment = 2 * (numRows - 1);
                int index = row;
                while (index < slength) {
                    System.out.println("index=" + index + ", resultIndex=" + resultIndex);
                    result[resultIndex] = s.charAt(index);
                    index += increment;
                    resultIndex++;
                }
            } else {
                int[] increment = { 2 * (numRows - row - 1), 2 * row };
                boolean toggle = true; // use first increment, else use the second;
                int index = row;
                while (index < slength) {
                    result[resultIndex] = s.charAt(index);
                    index += toggle ? increment[0] : increment[1];
                    toggle = !toggle;
                    resultIndex++;
                }
            }
        }
        // System.out.println(s+"'s result:"+String.valueOf(result));
        return String.valueOf(result);
    }
}

// https://leetcode.com/problems/zigzag-conversion/solutions/3049344/c-such-an-easy-solution/
class SolutionP2StrZigZag2 {
    public String convert(String s, int numRows) {
        String rows[] = new String[numRows];
        for(int i=0;i<numRows;i++){
            rows[i] = "";
        }
        boolean down = true;
        int currentRow = 0;
        if(numRows == 1) return s;
        for (int i = 0; i < s.length(); i++) {
            rows[currentRow] = rows[currentRow].concat(s.charAt(i) + "");
            if (currentRow == numRows - 1) {
                down = false;
            }
            if (currentRow == 0) {
                down = true;
            }
            if (down) {
                currentRow++;
            } else {
                currentRow--;
            }
        }
        String result = "";
        for(int i=0;i<numRows;i++){
            result = result.concat(rows[i]);
        }
        return result;
    }
}

public class P2StrZigZag {
    public static void main(String[] args) {
        SolutionP2StrZigZag2 sol = new SolutionP2StrZigZag2();
        assert sol.convert("PAYPALISHIRING", 1).equals("PAYPALISHIRING");
        assert sol.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR");
        assert sol.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI");
        assert sol.convert("A", 2).equals("A");
    }
}
