import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/word-pattern/description/

class Pair<T,U> {
    public T first;
    public U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}
class Zip<T,U> {
    private List<Pair<T,U>> value;
    public Zip(List<T> list1, List<U> list2) {
        int zipSize = Math.min(list1.size(), list2.size());
        value = new ArrayList<Pair<T,U>>(zipSize);
        for(int i=0;i<zipSize;i++) {
            value.set(i, new Pair<T, U>(list1.get(i), list2.get(i)));
        }
    }
}

interface SolutionP0IsomorphicStrings {
    public boolean isIsomorphic(String s, String t);
}

class SolutionP0IsomorphicStrings1 implements SolutionP0IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        String[] lettersInS = s.split("");
        String[] lettersInT = t.split("");
        HashSet<String> sSet = new HashSet<String>();
        HashSet<String> tSet = new HashSet<String>();
        for(int i=0;i<lettersInS.length;i++) {
            sSet.add(lettersInS[i]);
        }
        for(int i=0;i<lettersInT.length;i++) {
            tSet.add(lettersInT[i]);
        }
        if(sSet.size() != tSet.size()) {
            return false;
        }

        // check for mapping
        HashSet<String> mappingSet = new HashSet<String>();
        for(int i=0;i<s.length();i++) {
            String str = new String(s.substring(i, i+1)).concat(t.substring(i, i+1));
            mappingSet.add(str);
        }
        Boolean isMappingRight = mappingSet.size() == tSet.size();
        if(!isMappingRight) {
        }
        return isMappingRight;
    }
}

class SolutionP0IsomorphicStrings2 implements SolutionP0IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            if(sMap.containsKey(s.charAt(i))) {
                if(sMap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }else {
                sMap.put(s.charAt(i), t.charAt(i));
            }
            if(tMap.containsKey(t.charAt(i))) {
                if(tMap.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            }else {
                tMap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}

class P0IsomorphicStrings {
    public static void main(String[] args) {
        SolutionP0IsomorphicStrings sol = new SolutionP0IsomorphicStrings2();
        assert sol.isIsomorphic(new String("egg"), "add");
        assert !sol.isIsomorphic("foo", "bar");
        assert sol.isIsomorphic("paper", "title");
    }    
}
