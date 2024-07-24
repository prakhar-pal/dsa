package core.basics;

import java.util.*;
public class TrieNodeImpl {
    public static void main(String[] args) {
        TrieNode rootNode = new TrieNode('*');
        Set<String> wordSet = new HashSet<String>();
        String[] strArr = new String[] {"apple", "banana", "doctor"};
        for(String s: strArr) {
            wordSet.add(s);
            rootNode.insert(s, 0);
        }
        Set<String> foundWordSet = new HashSet<>();
        StringBuffer foundString = new StringBuffer();
        findAllWords(rootNode, foundWordSet, foundString);
        assert foundWordSet.equals(wordSet);
    }

    private static void findAllWords(TrieNode node, Set<String> foundWordSet, StringBuffer foundString) {
        if(node.isWord) {
            foundWordSet.add(foundString.toString());
        }
        for(char ch: node.children.keySet()) {
            foundString.append(ch);
            findAllWords(node.children.get(ch), foundWordSet, foundString);
            foundString.delete(foundString.length() - 1, foundString.length());
        }
    }   
}
