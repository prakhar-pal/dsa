package lc.math;

// https://leetcode.com/problems/excel-sheet-column-number/

class SolutionP3ExcelColumnNumber {
    public int titleToNumber(String columnTitle) {
        char a = 'A';
        int column = 0;
        int endIndex = columnTitle.length()-1;
        for(int i=endIndex;i>=0;i--) {
            int power = endIndex - i;
            column+= (columnTitle.charAt(i) - a + 1)*Math.pow(26, power);
        }
        return column;
    }
}

class P3ExcelColumnNumber {
    public static void main(String[] args) {
        SolutionP3ExcelColumnNumber sol = new SolutionP3ExcelColumnNumber();
        assert sol.titleToNumber("A") == 1;
        assert sol.titleToNumber("AB") == 28;
        assert sol.titleToNumber("ZY") == 701;
    }
}
