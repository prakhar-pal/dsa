package lc.Backtracking;
import java.util.*;;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class BT03GenerateParatheses {
    public static void main(String[] args) {
        BT03Solution sol = new BT03Solution();
        List<String> result1 = sol.generateParenthesis(3);
        System.out.println("for n=3");
        for(String s: result1) {
            System.out.print(s+ "\t");
        }
        System.out.println();

        List<String> result2 = sol.generateParenthesis(1);
        System.out.println("for n=1");
        for(String s: result2) {
            System.out.print(s+ "\t");
        }
        System.out.println();
    }
}

class BT03Solution {
    List<String> results;
    public List<String> generateParenthesis(int n) {
        results = new ArrayList<>();
        gpUtil("(", n-1, 1);
        return results;
    }

    private void gpUtil(String str, int n, int closures) {
        if(n == 0) {
            StringBuffer sb = new StringBuffer(str);
            for(int i=0;i<closures;i++) {
                sb.append(")");
            }
            results.add(sb.toString());
            return;
        }
        if(n > 0) {
            gpUtil(str + "(", n-1, closures + 1);
        }
        if(closures > 0) {
            gpUtil(str + ")", n, closures - 1);
        }
    }
}
