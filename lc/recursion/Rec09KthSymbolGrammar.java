// https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/
import java.util.Scanner;
class SolutionRec09KthSymbolGrammar {
    public int kthGrammar(int n, int k) {
        int result;
        if(n==1 || k==1) {
            result = 0;
        }
        else {
            int prevK = (int)Math.ceil(k*1.0/2);
            int previousGrammar = kthGrammar(n-1,prevK);
            if(previousGrammar == 0){
                result = k % 2== 0 ? 1 : 0;
            }else {
                result = k % 2== 0 ? 0 : 1;
            }
        }
        return result;
    }
}

class Rec09KthSymbolGrammar {
    public static void main(String[] args){
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int i=0;
        while(i<T){
            i++;
            System.out.println("case no:"+i);
            int n, k;
            n = sc.nextInt();
            k = sc.nextInt();
            SolutionRec09KthSymbolGrammar sol = new SolutionRec09KthSymbolGrammar();
            System.out.println(sol.kthGrammar(n,k));
        }
        sc.close();
    }
}
