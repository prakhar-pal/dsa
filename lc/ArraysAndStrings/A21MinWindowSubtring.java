package lc.ArraysAndStrings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class A21MinWindowSubtring {
    public static void main(String[] args) throws FileNotFoundException {
        A21Solution solution = new A21SolutionTwo();
        assert solution.minWindow("ADOBECODEBANC", "ABC").equals("BANC");
        assert solution.minWindow("a", "a").equals("a");
        assert solution.minWindow("a", "aa").equals("");
        assert solution.minWindow("bba", "ab").equals("ba");
        assert solution.minWindow("aa", "aa").equals("aa");

        File file = new File("lc/ArraysAndStrings/A21Input.txt");
        Scanner scanner = new Scanner(file);
        String s1 = scanner.nextLine();
        String t1 = scanner.nextLine();
        String output1 = scanner.nextLine();
        assert solution.minWindow(s1, t1).equals(output1);
        scanner.close();
    }
}

interface A21Solution {
    public String minWindow(String s, String t);
}

class A21SolutionOne implements A21Solution {
    // O(mlogn) algorithm, passes only 50% of the test cases, rest TLE
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        Deque<Integer> queue = new LinkedList<>();
        int left = 0, right = 0;
        for(int i=0;i<t.length();i++) {
            char ch = t.charAt(i);
            map.put(ch, (map.containsKey(ch) ? map.get(ch) : 0) + 1);
        }
        int count = 0;
        int i=0;
        for(;i<s.length() && count < t.length() ;i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                if(map.get(ch) > 0) {
                    map.put(ch, map.get(ch) - 1);
                    count++;
                }
                queue.addLast(i);
            }
        }
        if(count != t.length()) {
            return "";
        }
        for(int j=0;j<t.length();j++) {
            char ch = t.charAt(j);
            map.put(ch, (map.containsKey(ch) ? map.get(ch) : 0) + 1);
        }
        left = queue.peekFirst();
        right = queue.peekLast();
        for(;i<s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                queue.addLast(i);
                map.put(ch, map.get(ch) + 1);
            }
            while(map.get(s.charAt(queue.peekFirst())) > 1) {
                char ch2 = s.charAt(queue.pollFirst());
                map.put(ch2, map.get(ch2) - 1);
            }
            if(right - left > queue.peekLast() - queue.peekFirst()) {
                left = queue.peekFirst();
                right = queue.peekLast();
            }
        }
        return s.substring(left, right+1);
    }
}


class A21SolutionTwo implements A21Solution {
    // O(m + n) algorithm, passes only 50% of the test cases
    // reference: neetcode
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(char ch: t.toCharArray())  {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        int totalCount = map.keySet().size();
        int left = 0;
        String result = s + s;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                if(sMap.get(ch).equals((map.get(ch)))) {
                    count++;
                }
                while(count == totalCount && left < s.length()) {
                    while(!map.containsKey(s.charAt(left)) && left < s.length()) {
                        left++;
                    }
                    if(left == s.length()) {
                        break;
                    }
                    char leftChar = s.charAt(left);
                    if(i-left + 1 < result.length()) {
                        result = s.substring(left, i+1);
                    }
                    sMap.put(leftChar, sMap.get(leftChar) - 1);
                    if(sMap.get(leftChar) < map.get(leftChar)) {
                        count--;
                    }
                    left++;
                }
            }
        }
        if(result.length() > s.length()) {
            return "";
        }
        return result;
    }
}
