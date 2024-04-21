package lc.Backtracking;
import java.util.*;

public class BT02LetterCombinations {
    public static void main(String[] args) {
        BT02LCSolution sol = new BT02LCSolution();

        assert new HashSet<String>(sol.letterCombinations("23")).equals(new HashSet<String>(
           new ArrayList<String>(Arrays.asList( new String[] {
            "ad","ae","af","bd","be","bf","cd","ce","cf"
        }))));

        assert new HashSet<String>(sol.letterCombinations("")).equals(new HashSet<String>(
           new ArrayList<String>(Arrays.asList( new String[] {}))));

        assert new HashSet<String>(sol.letterCombinations("2")).equals(new HashSet<String>(
            new ArrayList<String>(Arrays.asList( new String[] {
                "a","b","c"
         }))));
    }
}

class NumToStrings {
    public HashMap<Integer, List<String>> mapping;
    public NumToStrings() {
        mapping = new HashMap<>();
        mapping.put(2, new ArrayList<String>(Arrays.asList(new String[] {"a", "b", "c"})));
        mapping.put(3, new ArrayList<String>(Arrays.asList(new String[] {"d", "e", "f"})));
        mapping.put(4, new ArrayList<String>(Arrays.asList(new String[] {"g", "h", "i"})));
        mapping.put(5, new ArrayList<String>(Arrays.asList(new String[] {"j", "k", "l"})));
        mapping.put(6, new ArrayList<String>(Arrays.asList(new String[] {"m", "n", "o"})));
        mapping.put(7, new ArrayList<String>(Arrays.asList(new String[] {"p", "q", "r", "s"})));
        mapping.put(8, new ArrayList<String>(Arrays.asList(new String[] { "t", "u", "v"})));
        mapping.put(9, new ArrayList<String>(Arrays.asList(new String[] {"z", "y", "x", "w"})));
    }
}

class BT02LCSolution {
    NumToStrings nts;
    public BT02LCSolution() {
        if(nts == null) {
            nts = new NumToStrings();
        }
    }
    public List<String> letterCombinations(String digits) {
        int dlength = digits.length();
        List<List<String>> strings = new ArrayList<>(dlength);
        for(int i=0;i<dlength;i++) {
            int num = Integer.parseInt(digits.charAt(i) + "");
            strings.add(nts.mapping.get(num));
        }
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }else {
            result = strings.get(0);
        }
        for(int i=1;i<strings.size();i++) {
            List<String> tresult = new ArrayList<>();
            for(String s0: result) {
                for(String s1: strings.get(i)) {
                    tresult.add(s0 + s1);
                }
            }
            result = tresult;
        }
        return result;
    }
}
