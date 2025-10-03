package lc.Backtracking;
import basics.*;
import java.util.*;

/*
 * https://leetcode.com/problems/word-search-ii
 */
public class BT08WordSearch2 {
    public static void main(String[] args) {
        BT08Solution solution = new BT08SolutionTwo();
        HashSet<String> expected1 = new HashSet<>();
        Collections.addAll(expected1, "eat","oath");
        List<String> resutl1List = solution.findWords(new char[][] {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        }, new String[]{"oath","pea","eat","rain"});
        Set<String> resutl1 = new HashSet<>(resutl1List);
        assert resutl1.equals(expected1);
        List<String> result2 = List.of(new String[] {});
        assert solution.findWords(new char[][] {
            {'a','b'},
            {'c','d'},
        }, new String[]{"acbc"}).equals(result2);
    }
}

interface BT08Solution {
    public List<String> findWords(char[][] board, String[] words);
}
class BT08SolutionOne implements BT08Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<Character> firstLetterSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>();
        HashMap<Character, Integer> minLength = new HashMap<>();
        HashMap<Character, Integer> maxLength = new HashMap<>();
        for(String word: words) {
            Character key = word.charAt(0);
            firstLetterSet.add(key);
            wordSet.add(word);
            minLength.put(key, Math.min(minLength.getOrDefault(key, Integer.MAX_VALUE), word.length()));
            maxLength.put(key, Math.max(maxLength.getOrDefault(key, Integer.MIN_VALUE), word.length()));
        }
        boolean[][] visited = new boolean[board.length][board.length > 0 ? board[0].length : 0];
        HashSet<String> resultSet = new HashSet<>();
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++){
                char key = board[i][j];
                if(firstLetterSet.contains(key)) {
                    StringBuffer result = new StringBuffer();
                    backtrack(board, i, j, visited, wordSet, result, resultSet, minLength.get(key), maxLength.get(key));
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
    private void backtrack(char[][] board, int i, int j, boolean[][] visited, Set<String> wordSet, StringBuffer currentString, Set<String> resultSet, int minLength, int maxLength) {
        if(i<0 || i>= board.length || j<0|| j>=board[i].length || visited[i][j] || currentString.length() > maxLength) {
            return;
        }
        currentString.append(board[i][j]);
        if(currentString.length() >= minLength && currentString.length() <= maxLength) {
            String resultString = currentString.toString();
            if(wordSet.contains(resultString)) {
                resultSet.add(resultString);
            }
        }
        visited[i][j] = true;
        backtrack(board, i+1, j, visited, wordSet, currentString, resultSet, minLength, maxLength);
        backtrack(board, i-1, j, visited, wordSet, currentString, resultSet, minLength, maxLength);
        backtrack(board, i, j+1, visited, wordSet, currentString, resultSet, minLength, maxLength);
        backtrack(board, i, j-1, visited, wordSet, currentString, resultSet, minLength, maxLength);
        currentString.delete(currentString.length() - 1, currentString.length());
        visited[i][j] = false;
    }
}

class BT08SolutionTwo implements BT08Solution {
    // Trie based solution
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode rootNode = new TrieNode('*');
        for(String word: words) {
            rootNode.insert(word, 0);
        }
        HashSet<String> foundWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board.length > 0 ? board[0].length : 0];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                StringBuffer formedWord = new StringBuffer();
                findWordUtil(board, rootNode, visited, i, j, foundWords, formedWord);
            }
        }
        List<String> result = new ArrayList<>();
        for(String foundWord: foundWords) {
            result.add(foundWord);
        }
        return result;
    }

    private void findWordUtil(char[][] board, TrieNode node, boolean[][] visited , int i, int j, Set<String> foundWords, StringBuffer formedWord) {
        if(i<0 || i>= board.length || j<0|| j>=board[i].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        char ch = board[i][j];
        if(node.children.containsKey(ch)) {
            TrieNode childNode = node.children.get(ch);
            formedWord.append(board[i][j]);
            if(childNode.isWord) {
                foundWords.add(formedWord.toString());
            }
            findWordUtil(board, childNode, visited, i+1, j, foundWords, formedWord);
            findWordUtil(board, childNode, visited, i-1, j, foundWords, formedWord);
            findWordUtil(board, childNode, visited, i, j+1, foundWords, formedWord);
            findWordUtil(board, childNode, visited, i, j-1, foundWords, formedWord);
            formedWord.delete(formedWord.length() - 1, formedWord.length());
        }
        visited[i][j] = false;
    }
}
