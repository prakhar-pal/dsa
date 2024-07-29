package lc.ArraysAndStrings;

/**
 * https://leetcode.com/problems/ransom-note/description/
 */
public class S10RansomNote {
    public static void main(String[] args) {
        S10Solution solution = new S10Solution();
        assert solution.canConstruct("aa", "aab");
        assert solution.canConstruct("aa", "ab") == false;
        assert solution.canConstruct("a", "b") == false;
    }
}

class S10Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] noteFrequency = new int[26];
        int[] magazineFrequency = new int[26];
        char[] rc = ransomNote.toCharArray();
        char[] mc = magazine.toCharArray();
        for(int i=0;i<rc.length;i++) {
            noteFrequency[rc[i]-'a']++;
        }
        for(int i=0;i<mc.length;i++) {
            magazineFrequency[mc[i]-'a']++;
        }
        for(int i=0;i<noteFrequency.length;i++) {
            if(magazineFrequency[i] < noteFrequency[i]) {
                return false;
            }
        }
        return true;
    }
}
