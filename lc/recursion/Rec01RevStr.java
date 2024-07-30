package lc.recursion;

//https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/

class SolutionRec01RevStr {
    public void reverseString(char[] s) {
        int i=0, j=s.length-1;
        reverseString(s,i,j);
    }
    private void reverseString(char[] s, int i, int j){
        if(i>j){
            return;
        }else {
            reverseString(s, i+1, j-1);
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}

public class Rec01RevStr {
    public static void main(String[] args) {
        char[] s1 = {'h','e','l','l','o'};
        char[] s2 = {'H','a','n','n','a','h'};
        SolutionRec01RevStr sol = new SolutionRec01RevStr();
        sol.reverseString(s1);
        sol.reverseString(s2);
        System.out.println(s1);
        System.out.println(s2);
    }
}
