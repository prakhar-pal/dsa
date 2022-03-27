// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
// First Unique Character in a String

class Solution {
    public int firstUniqChar(String s) {
        int[] freqs = new int[26];
        for(int i=0;i<26;i++){
            freqs[i] = 0;
        }
        for(int i=0;i<s.length();i++){
            int pos = (int)(s.charAt(i) - 'a');
            freqs[pos]++;
        }
        for(int i=0;i<s.length();i++){
            int pos = (int)(s.charAt(i) - 'a');
            if(freqs[pos] == 1){
                return i;
            }
        }
        return -1;
    }
}

class S02 {
    public static void main(String[] args){
        String s1 = "leetcode";
        int index1 = 0;
        String s2 = "loveleetcode";
        int index2 = 2;
        String s3 = "aabb";
        int index3 = -1;
        
        Solution sol = new Solution();
        
        assert sol.firstUniqChar(s1) == index1;
        assert sol.firstUniqChar(s2) == index2;
        assert sol.firstUniqChar(s3) == index3;
    }
}
