package lc.trees;

class T29WordDataStructure {
    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        assert dict.search("pad") == false;
        assert dict.search("bad") == true;
        assert dict.search(".ad") == true;
        assert dict.search("b..") == true;

         dict = new WordDictionary();
        dict.addWord("at");
        dict.addWord("and");
        dict.addWord("an");
        dict.addWord("add");
        assert dict.search("a") == false;
        assert dict.search(".at") == false;
        dict.addWord("bat");
        assert dict.search(".at") == true;
        assert dict.search("an.") == true;
        assert dict.search("a.d.") == false;
        assert dict.search("b.") == false;
        assert dict.search("a.d") == true;
        assert dict.search(".") == false;
    }
}

class WordDictionary {
    Trie2 trie;

    public WordDictionary() {
        trie = new Trie2();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }

    class Trie2 {
        Trie2[] next;
        boolean[] isWord;
        private static int CHARS_COUNT = 26;

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
            System.out.printf("search %s in dictionary \n", word);
            return Trie2.searchUtil(this, word, 0);
        }

        private static boolean searchUtil(Trie2 trie, String word, int index) {
            if(index >= word.length()) {
                return true;
            }
            char ch = word.charAt(index);
            if (ch == '.') {
                // A '.' matches everything
                if(index == word.length() - 1) {
                    for(int i=0;i<Trie2.CHARS_COUNT;i++) {
                        // current character is a '.', which matches with any character
                        // so, at least at least one of the letters should be a part of a word ending
                        if(trie.isWord[i]) {
                            return true;
                        }
                    }
                    return false;
                }
                for (int i = 0; i < Trie2.CHARS_COUNT; i++) {
                    if (trie.next[i] == null) {
                        continue;
                    }
                    if (searchUtil(trie.next[i], word, index + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                int trieIndex = ch - 'a';
                Trie2 nextTrie = trie.next[trieIndex];
                if (nextTrie != null && (index == word.length() - 1 ? trie.isWord[trieIndex] : searchUtil(nextTrie, word, index + 1))) {
                    // System.out.println("found:"+ch);
                    return true;
                }
            }
            return false;
        }
    }
}
