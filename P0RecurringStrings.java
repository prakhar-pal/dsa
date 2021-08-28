// I3 test talentica
// for Sanny K

class UserMainCode {
    private boolean isSameString(String s1, String s2){
        boolean hasMove = true;
        if(s1.length() != s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 == ch2){
                continue;
            }else if(hasMove){
                hasMove = false;
                char ch3 = (char)(ch1+1);
                if(ch3 > 'Z') ch3 = 'A';
                if(ch3 == ch2) continue;
                ch3 = (char)(ch2 + 1);
                if(ch3 > 'Z') ch3 = 'A';
                if(ch3 == ch1) continue;
                else return false;
            }else return false;
        }
        return true;
    }
    public int recurringString(int N, String[] strings, String matchStr){
        int count = 0;
        for(String str:strings){
            if(isSameString(str, matchStr)){
                count++;
            }
        }
        return count;
    }
}

public class P0RecurringStrings {
    public static void main(String[] args) {
        UserMainCode umc = new UserMainCode();
        // example 1
        String[] strings1 = {"AAAA", "BAAA"};
        String matchStr1 = "BAAA";
        System.out.println("match strings [1]:" + umc.recurringString(strings1.length, strings1, matchStr1));

        // example 2 
        String[] strings2 = {"ABCD", "ACCD", "ACBD", "ABCD","ABCD", "ACBD"};
        String matchStr2 = "ACCD";
        System.out.println("match strings [2]:" + umc.recurringString(strings2.length, strings2, matchStr2));
    }
}
