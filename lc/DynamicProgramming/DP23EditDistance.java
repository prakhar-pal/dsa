package lc.DynamicProgramming;

import java.util.Arrays;

public class DP23EditDistance {
    public static void main(String[] args) {
        DP23Solution sol = new DP23Solution();
        assert sol.minDistance("horse", "ros") == 3;
        assert sol.minDistance("intention", "execution") == 5;
        assert sol.minDistance("abcd", "cd") == 2;
    }
}

class DP23Solution {
    int[][] cache;
    public int minDistance(String word1, String word2) {
        cache = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(cache[i], -1);
        }
        System.out.println("midDistance="+minDistance(word1, word2, 0, 0));
        return minDistance(word1, word2, 0, 0);
    }

    private int minDistance(String word1, String word2, int i, int j) {
        if (i >= word1.length() || j >= word2.length()) {
            if(i >= word1.length()) {
                return word2.length() - j;
            }
            return word1.length() - i;
        }
        if (cache[i][j] == -1) {
            if (i < word1.length() & j < word2.length() && word1.charAt(i) == word2.charAt(j)) {
               cache[i][j] = minDistance(word1, word2, i+1, j+1);
            } else {
                int cost = 1 + minDistance(word1, word2, i + 1, j + 1); // replace character at i with character at j
                cost = Math.min(cost, 1 + minDistance(word1, word2, i + 1, j)); // delete character at i and match with
                                                                                // i+1
                cost = Math.min(1 + minDistance(word1, word2, i, j + 1), cost); // insert a character
                cache[i][j] = cost;
            }
        }
        return cache[i][j];
    }
}