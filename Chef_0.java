import java.util.Scanner;

class Chef_0{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            Scanner sc2 = new Scanner(System.in);
            int num = sc2.nextInt();
            int min = num;
            String numString = num + "";
            for(int i=0;i<numString.length();i++){
                int amount = num - Integer.parseInt(numString.charAt(i)+ "") * Math.pow(10, numString.length()-i-1);
                if(amount<min)
                    min = amount;
            }
            System.out.println(min);
        }
    }
}