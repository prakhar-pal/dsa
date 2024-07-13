package lc.trees;
import java.util.*;
public class T12WordLadder {
    public static void main(String[] args) {
        A12Solution solution = new A12Solution();
        List<String> list1 = new ArrayList<String>();
        Collections.addAll(list1, "hot","dot","dog","lot","log","cog");
        assert solution.ladderLength("hit", "cog", list1) == 5;

        List<String> list2 = new ArrayList<String>();
        Collections.addAll(list1, "hot","dot","dog","lot","log");
        assert solution.ladderLength("hit", "cog", list2) == 0;
    }
}

class A12Solution {
    private Set<String> generatePatterns(String word) {
        Set<String> patternSet = new HashSet<>();
        for(int i=0;i<word.length();i++) {
            String pattern = word.substring(0,i) + "*" + word.substring(i + 1);
            patternSet.add(pattern);
        }
        return patternSet;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 1;
        boolean hasFound = false;
        HashMap<String, HashSet<String>> patternMap = new HashMap<>();
        for(String word: wordList) {
            Set<String> patternSet = generatePatterns(word);
            for(String pattern: patternSet) {
                HashSet<String> list;
                if(patternMap.containsKey(pattern)) {
                    list = patternMap.get(pattern);
                }else {
                    list = new HashSet<>();
                }
                list.add(word);
                patternMap.put(pattern, list);
            }
        }
        HashSet<String> visitedPatterns = new HashSet<>();
        Set<String> currentPatterns = generatePatterns(beginWord);
        while (currentPatterns.size() != 0) {
            HashSet<String> nextWords = new HashSet<>();
            for(String pattern: currentPatterns) {
                if(patternMap.containsKey(pattern)) {
                    for(String word: patternMap.get(pattern)) {
                        nextWords.add(word);
                    }
                }
            }
            for(String nextWord: nextWords) {
                if(nextWord.equals(endWord)) {
                    hasFound = true;
                    break;
                }
            }
            length++;
            if(hasFound) {
                break;
            }
            for(String pattern: currentPatterns) {
                visitedPatterns.add(pattern);
            }
            Set<String> nextPatterns = new HashSet<>();
            for(String word: nextWords) {
                Set<String> patternSet = generatePatterns(word);
                for(String pattern: patternSet) {
                    if(visitedPatterns.contains(pattern)) {
                        continue;
                    }
                    nextPatterns.add(pattern);
                }
            }
            currentPatterns = nextPatterns;
        }
        return hasFound ? length : 0;
    }
}
