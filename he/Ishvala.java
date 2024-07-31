package he;

import java.util.Scanner;

class Ishvala {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int out[] = new int[t];
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
            int m = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
			int houseSize = sc.nextInt();
			int x[] = new int[X+1];
            int y[] = new int[Y+1];
            x[X] = n+1;
            y[Y] = m+1;
			if(X>0) {
				for(int j=0;j<X;j++)
					x[j] = sc.nextInt();
			}
			if(Y>0) {
				for(int j=0;j<Y;j++)
					y[j] = sc.nextInt();
            }
            // int x[] = {1,4,7}, y[] = {6};
            // int houseSize = 1;
            out[i] = new Solver().getHouseCount(x, y, houseSize);
        }
        for(int i=0;i<t;i++) {
            System.out.println(out[i]);
        }
	}
}

class Solver{
	public int getHouseCount(int x[],int y[],int houseSize) {
        int x1[] = new int[x.length];
        for(int i=0; i<x.length;i++){
            x1[i] = x[i] - (i==0? 0 : x[i-1]) -1;
        }
        int xCount = 0;
        // System.out.println("x are:");
        for(int i=0; i<x.length;i++){
            // System.out.println(x1[i]+", "+x1[i]/houseSize);
            x1[i] = x1[i]/houseSize;
            if(x1[i]>0) xCount +=x1[i];
        }

        // for(int i=0; i<x.length;i++){
        //     x[i] = x[i]/houseSize;
        //     if(x[i]>0) xCount +=x[i];
        // }
        int y1[] = new int[y.length];
        for(int i=0; i<y.length;i++){
            y1[i] = y[i] - (i==0? 0 : y[i-1]) -1;
        }
        int yCount = 0;
        // System.out.println("y are:");
        for(int i=0; i<y.length;i++){
            // System.out.println(y1[i]+", "+y1[i]/houseSize);
            y1[i] = y1[i]/houseSize;
            if(y1[i]>0) yCount +=y1[i];
        }
        // System.out.println("xCount is: "+xCount+", yCount is:"+yCount);
		return xCount*yCount;
	}
}
