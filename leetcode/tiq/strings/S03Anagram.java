class Solution {
    private int getCharPos(char ch){
        return (int)(ch - 'a');
    }
    private int[] getFreqArr(String s){
        int[] freqs = new int[26];
        for(int i=0;i<26;i++){
            freqs[i] = 0;
        }
        for(int i=0;i<s.length();i++){
            freqs[getCharPos(s.charAt(i))]++;
        }
        return freqs;
    }
    public boolean isAnagram(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if(n1 != n2) return false;
        int[] freqS = this.getFreqArr(s);
        int[] freqT = this.getFreqArr(t);
        for(int i=0;i<freqS.length;i++){
            if(freqS[i] != freqT[i]) return false;
        }
        return true;
    }
}

class S03 {
    public static void main(String[] args){
        String s1 = "anagram", t1 = "nagaram";
        boolean result1 = true;
        String s2 = "rat", t2 = "car";
        boolean result2 = false;
        
        Solution sol = new Solution();
        
        assert sol.isAnagram(s1,t1) == result1;
        assert sol.isAnagram(s2,t2) == result2;
    }
}
