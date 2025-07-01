import java.util.Scanner;

public class Prog201 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = 0;
        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                for(int k=1;k<=j;k++){
                    r++;
                }
            }
        }
        sc.close();
        System.out.println(r);
    }
}
