package lc.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import lc.ArraysAndStrings.ArrayUtils;

public class DP16WordBreak {
    public static void main(String[] args) {
        DPH05Solution sol = new DPH05SolutionFour();
        assert sol.wordBreak("leetcode", ArrayUtils.arrayToList(new String[] {"leet","code"}));
        assert sol.wordBreak("cars", ArrayUtils.arrayToList(new String[] {"car","ca", "rs"}));
        assert sol.wordBreak("applepenapple", ArrayUtils.arrayToList(new String[] {"apple","pen"}));
        assert sol.wordBreak("catsandog", ArrayUtils.arrayToList(new String[] {"cats","dog","sand","and","cat"})) == false;
        assert sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
            ArrayUtils.arrayToList(new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})
        ) == false;
    }
}

class DPH05SolutionFour implements DPH05Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[ length + 1];
        dp[length] = true;
        for(int i=length-1;i>=0;i--) {
            String subString = s.substring(i, length);
            int matchWordLength = -1;
            for(int j=0; j < wordDict.size() && !dp[i];j++) {
                String word = wordDict.get(j);
                if(subString.length() >= word.length() && subString.indexOf(word) == 0) {
                    matchWordLength = word.length();
                    dp[i] = dp[i+matchWordLength];
                }
            }
        }
        return dp[0];
    }
}

class TrieNode {
    private HashMap<Character, TrieNode> charSet;
    private HashMap<Character, Boolean> isWord;

    public TrieNode() {
        charSet = new HashMap<>();
        isWord = new HashMap<>();
    }

    public void add(String word) {
        if(word.length() == 0) {
            return;
        }
        char ch = word.charAt(0);
        if(charSet.containsKey(ch)) {
            TrieNode node = charSet.get(ch);
            node.add(word.substring(1));
        } else {
            TrieNode node = new TrieNode();
            node.add(word.substring(1));
            charSet.put(ch, node);
        }
        if(word.length() == 1) {
            isWord.put(ch, true);
        }
    }

    public List<Integer> findWords(String s, int start) {
        List<Integer> list = new ArrayList<>();
        TrieNode node = this;
        for(int i=start; i<s.length();i++) {
            char ch = s.charAt(i);
            if(node.charSet.containsKey(ch)) {
                if(node.isWord.containsKey(ch)) {
                    list.add(i);
                }
                node = node.charSet.get(ch);
            } else {
                break;
            }
        }
        Collections.sort(list, Comparator.reverseOrder());
        return list;
    }
}

class DPH05SolutionThree implements DPH05Solution {
    // takes too much memory
    private TrieNode root;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        for(String word: wordDict) {
            root.add(word);
        }
        List<Integer> indices = root.findWords(s, 0);
        if(indices.contains(s.length() - 1)) {
            return true;
        }
        while(indices.size() != 0) {
            if(indices.contains(s.length() - 1)) {
                return true;
            }
            List<Integer> newIndices = new ArrayList<>();
            for(int index: indices) {
                List<Integer> nextIndices = root.findWords(s, index + 1);
                for(int i: nextIndices) {
                    newIndices.add(i);
                }
            }
            indices = newIndices;
        }
        return false;
    }
}

class DPH05SolutionTwo implements DPH05Solution {
    // TLE
    private static HashMap<Integer, List<String>> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        for(String word: wordDict) {
            int hash = word.hashCode();
            if(map.containsKey(hash)) {
                map.get(hash).add(word);
            }else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(hash, list);
            }
        }
        return wordBreak(s, wordDict, 0);
    }

    private boolean isWordInMap(String s) {
        int hash = s.hashCode();
        if(map.containsKey(hash)) {
            List<String> list = map.get(hash);
            for(String ls: list) {
                if(ls.equals(s)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    private boolean wordBreak(String s, List<String> wordDict, int start) {
        if(start>=s.length()) {
            return true;
        }
        boolean wordBroke = false;
        for(int i = start;i<s.length() && !wordBroke;i++) {
            String searchString = s.substring(start, i+1);
            boolean isPresent = isWordInMap(searchString);
            if(isPresent) {
                wordBroke = wordBreak(s, wordDict, i+1);
            }
        }
        return wordBroke;
    }
}


interface DPH05Solution {
    public boolean wordBreak(String s, List<String> wordDict);
}

class DPH05SolutionOne implements DPH05Solution {
    // TLE
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }
    private boolean wordBreak(String s, List<String> wordDict, int start) {
        if(start>=s.length()) {
            return true;
        }
        boolean wordBroke = false;
        for(int i = start;i<s.length() && !wordBroke;i++) {
            String searchString = s.substring(start, i+1);
            for(String d: wordDict) {
                if(d.equals(searchString)) {
                    wordBroke = wordBreak(s, wordDict, i+1);
                }
            }
        }
        return wordBroke;
    }
}
