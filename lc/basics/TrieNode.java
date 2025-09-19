package basics;
import java.util.*;
public class TrieNode {
    public char value;
    public boolean isWord;
    public HashMap<Character, TrieNode> children;

    public TrieNode(char value) {
        this.value = value;
        isWord = false;
        children = new HashMap<>();
    }

    public void insert(String word, int index) {
        if (index >= word.length()) {
            return;
        }
        char key = word.charAt(index);
        TrieNode node = children.getOrDefault(key, new TrieNode(key));
        children.put(key, node);
        if (index == word.length() - 1) {
            node.isWord = true;
        } else {
            node.insert(word, index + 1);
        }
    }
}

