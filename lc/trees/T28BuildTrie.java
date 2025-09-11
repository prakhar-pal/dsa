package lc.trees;

import java.util.HashMap;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class T28BuildTrie {

    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("apple");
        assert trie.search("app") == false;
        assert trie.startsWith("app") == true;
        trie.insert("app");
        assert trie.search("app") == true;
        assert trie.search("apples") == false;
        assert trie.startsWith("apples") == false;
        assert trie.startsWith("apple") == true;
        assert trie.search("mango") == false;
        assert trie.startsWith("ape") == false;
    }
}

class Trie {
    class TrieLetter {
        public boolean isWord;
        public Trie next;

        public TrieLetter() {
            next = new Trie();
        }
    }

    HashMap<Character, TrieLetter> map;

    public Trie() {
        map = new HashMap<>();
    }

    public void insert(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!current.map.containsKey(ch)) {
                TrieLetter letter = new TrieLetter();
                current.map.put(ch, letter);
            }
            if (i == word.length() - 1) {
                TrieLetter letter = current.map.get(ch);
                letter.isWord = true;
            }
            current = current.map.get(ch).next;
        }
    }

    public boolean search(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current == null || !current.map.containsKey(ch)) {
                return false;
            }
            if (i == word.length() - 1) {
                TrieLetter letter = current.map.get(ch);
                return letter.isWord;
            }
            current = current.map.get(ch).next;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Trie current = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (current == null || !current.map.containsKey(ch)) {
                return false;
            }
            current = current.map.get(ch).next;
        }
        return true;
    }
}

// Second Try ;)
class Trie2 {
    Trie2[] next;
    boolean[] isWord;
    private int CHARS_COUNT = 26;

    public Trie2() {
        next = new Trie2[CHARS_COUNT];
        isWord = new boolean[CHARS_COUNT];
    }

    public void insert(String word) {
        Trie2 current = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int trieIndex = ch - 'a';
            if (current.next[trieIndex] == null) {
                Trie2 nextTrie = new Trie2();
                current.next[trieIndex] = nextTrie;
            }
            if (i == word.length() - 1) {
                current.isWord[trieIndex] = true;
            }
            current = current.next[trieIndex];
        }
    }

    public boolean search(String word) {
        Trie2 current = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int trieIndex = ch - 'a';
            if (current.next[trieIndex] == null) {
                return false;
            }
            if (i == word.length() - 1) {
                return current.isWord[trieIndex];
            }
            current = current.next[trieIndex];
        }
        return false; // TODO: default should be false
    }

    public boolean startsWith(String prefix) {
        Trie2 current = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int trieIndex = ch - 'a';
            if (current.next[trieIndex] == null) {
                return false;
            }
            current = current.next[trieIndex];
        }
        return true;
    }
}
