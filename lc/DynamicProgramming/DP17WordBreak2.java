package lc.DynamicProgramming;
import lc.ArraysAndStrings.ArrayUtils;
import lc.common.Logger;
import java.util.*;

public class DP17WordBreak2 {
    public static void main(String[] args) {
        DP17Solution sol = new DP17Solution();
        Logger.log(sol.wordBreak("catsanddog", ArrayUtils.arrayToList(new String[] {"cat","cats","and","sand","dog"})));;
    }
}

class DP17Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        backtrack(s, new HashSet<>(wordDict), 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, HashSet<String> dict, int position, List<String> curr, List<String> result) {
        if(position == s.length()) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<curr.size(); i++) {
                String word = curr.get(i);
                sb.append(word + (i == curr.size() - 1 ? "": " "));
            }
            result.add(sb.toString().trim());
        }
        for(int i=position+1;i<=s.length();i++) {
            String subString = s.substring(position, i);
            if(dict.contains(subString)) {
                curr.add(subString);
                backtrack(s, dict, i, curr, result);
                curr.remove(curr.size()-1);
            }
        }
    }
}

