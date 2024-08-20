package lc.random;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class R29ReverseWords {
    public static void main(String[] args) {
        R29Solution solution = new R29Solution();
        assert solution.reverseWords("the sky is blue").equals("blue is sky the");
        assert solution.reverseWords("  hello world  ").equals("world hello");
        assert solution.reverseWords("a good   example").equals("example good a");
    }
}

class R29Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String[] rwords = new String[words.length];
        for(int i=0;i<words.length;i++) {
            rwords[words.length-1-i] = words[i];
        }
        for(String w: rwords) {
            if(!w.equals("")) {
                sb.append(w + " ");
            }
        }
        return sb.toString().trim();
    }
}
