package lc.ArraysAndStrings;
import java.util.*;

public class S05GroupAnagrams {
    public static void main(String[] args) {
        S05Solution sol = new S05Solution();
        printList(sol.groupAnagrams(new String[] {
            "eat","tea","tan","ate","nat","bat"
        }));
        printList(sol.groupAnagrams(new String[] {}));
        printList(sol.groupAnagrams(new String[] {"a"}));
    }

    public static void printList(List<List<String>> list) {
        for(List<String>row : list) {
            for(String s: row) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }
}

class S05Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lol = new ArrayList<>();
        HashMap<String, Integer> positions = new HashMap<>();
        for(String s: strs) {
            char[] sarr = s.toCharArray();
            Arrays.sort(sarr);
            String sortedWord = new String(sarr);
            if(positions.containsKey(sortedWord)) {
                List<String> list = lol.get(positions.get(sortedWord));
                list.add(s);
            }else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                positions.put(sortedWord, lol.size());
                lol.add(newList);
            }
        }
        return lol;
    }
}
