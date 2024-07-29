package lc.ArraysAndStrings;
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
// check if a sentence is a palindrome 


interface S04Solution {
    public boolean isPalindrome(String s);
}


class S04SolutionOne implements S04Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder temp = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >='0' && ch <= '9')){
                temp.append(ch);
            }
        }
        String str = temp.toString();
        String revStr = temp.reverse().toString();
        return str.equals(revStr);
    }
}

class S04SolutionTwo implements S04Solution {
    public boolean isPalindrome(String original) {
        String s = original.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left<=right) {
            if(!isAlphaNumeric(s.charAt(left))) {
                left++;
                continue;
            }
            if(!isAlphaNumeric(s.charAt(right))) {
                right--;
                continue;
            }
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char ch) {
        if(ch >= 'a' && ch <= 'z') {
            return true;
        }
        if(ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }
}

class S04 {
    public static void main(String[] args){
        S04Solution sol = new S04SolutionTwo();
        
        String s1 = "A man, a plan, a canal: Panama";
        boolean result1 = true;

        String s2 = "race a car";
        boolean result2 = false;
        
        String s3 = " ";
        boolean result3 = true;
        
        assert sol.isPalindrome(s1) == result1;
        assert sol.isPalindrome(s2) == result2;
        assert sol.isPalindrome(s3) == result3;
    }
}
