import java.util.Scanner;
public class Prog202 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                for(int k=j;k<=(i+j);k++){
                    r++;
                }
            }
        }
        sc.close();
        System.out.println(r);
    }
}
