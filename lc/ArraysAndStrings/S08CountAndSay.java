package lc.ArraysAndStrings;

/**
 * https://leetcode.com/problems/count-and-say/
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 * For example, the saying and conversion for digit string "3322251":
 */
public class S08CountAndSay {
   public static void main(String[] args) {
        S08CountAndSaySolution sol = new S08CountAndSaySolution();
        assert sol.countAndSay(1).equals("1");
        assert sol.countAndSay(4).equals("1211");
   }
}

class CountAndSay {
    private int MAX_N = 30;
    public String[] result;
    public CountAndSay() {
        result = new String[MAX_N+1];
        result[1] = "1";
        for(int i=2;i<=MAX_N;i++) {
            result[i] = say(result[i-1]);
        }
    }

    private String say(String s) {
        StringBuffer sb = new StringBuffer();
        int counter = 1;
        char prevCharacter = s.charAt(0);
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i) == prevCharacter) {
                counter++;
            } else {
                sb.append(counter);
                sb.append(prevCharacter);
                prevCharacter = s.charAt(i);
                counter = 1;
            }
        }
        sb.append(counter);
        sb.append(prevCharacter);
        return sb.toString();
    }
}

class S08CountAndSaySolution {
    CountAndSay cas;
    public S08CountAndSaySolution() {
        if(this.cas == null) {
            this.cas = new CountAndSay();
        }
    }
    public String countAndSay(int n) {
        return this.cas.result[n];
    }
}
