package lc.DynamicProgramming;
import lc.utils.ArrayUtils;
import lc.utils.Clogger;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/description/
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class DP17WordBreak2 {
    public static void main(String[] args) {
        DP17Solution sol = new DP17SolutionTwo();
        Clogger.log(sol.wordBreak("catsanddog", ArrayUtils.arrayToList(new String[] {"cat","cats","and","sand","dog"})));;
    }
}

interface DP17Solution {
    public List<String> wordBreak(String s, List<String> wordDict);
}

class DP17SolutionTwo implements DP17Solution {
    // to use DP
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, HashSet<String>> map = new HashMap<>();
        HashSet<String> dict = new HashSet<>(wordDict);
        HashSet<String> initList = new HashSet<>();
        List<Integer> endIndices = new ArrayList<>();
        endIndices.add(s.length());
        initList.add("");
        map.put(s.length(), initList);
        for(int i=s.length()-1; i>=0;i--) {
            for(int j=0;j<endIndices.size();j++) {
                String substring = s.substring(i, endIndices.get(j));
                HashSet<String> currentSentences;
                int dIndex = i + substring.length();
                if(dict.contains(substring) && map.containsKey(dIndex)) {
                    if(map.containsKey(i)) {
                        currentSentences = map.get(i);
                    }else {
                        currentSentences = new HashSet<>();
                    }
                    HashSet<String> sentences = map.get(dIndex);
                    for(String sentence: sentences) {
                        currentSentences.add(new String(substring + " " + sentence).trim());
                    }
                    endIndices.add(i);
                    map.put(i, currentSentences);
                }
            }
        }
        if(map.containsKey(0)) {
            return new ArrayList<>(map.get(0));
        }else {
            return new ArrayList<>();
        }
    }
}

class DP17SolutionOne implements DP17Solution {
    // beats 94.18% solutions
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

