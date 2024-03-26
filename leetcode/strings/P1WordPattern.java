import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/word-pattern/description/
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, String> match = new HashMap<>();
        String[] letters = pattern.split("");
        String[] words = s.split(" ");
        if(letters.length != words.length) {
            return false;
        }
        HashSet<String> letterSet, wordSet;
        letterSet = new HashSet<>();
        wordSet = new HashSet<>();
        Collections.addAll(letterSet, letters);
        Collections.addAll(wordSet, words);
        if(letterSet.size() != wordSet.size()) {
            return false;
        }
        for(int i=0;i<letters.length;i++) {
            if(match.containsKey(letters[i])) {
                if(!match.get(letters[i]).equals(words[i])) {
                    // System.out.println(match.get(letters[i])+ " is the match of " + letters[i] + " but current word is " + words[i]);
                    return false;
                }
            } else {
                match.put(letters[i], words[i]);
            }
        }
        return true;
    }
}
public class P1WordPattern {
 public static void main(String[] args) {
    Solution sol  = new Solution();
    assert sol.wordPattern("abba", "dog cat cat dog");
    assert sol.wordPattern("abba", "dog cat cat fish") == false;
    assert sol.wordPattern("aaaa", "dog cat cat dog") == false;
    assert sol.wordPattern("abba", "dog dog dog dog") == false;
 }   
}
