import java.util.LinkedList;
// import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    private boolean[][] visited;
    private boolean[][] processed;

    public Solution(){
    }
    public void printSolution(int r, int c, int x, int y){
        int[][] matrix = new int[r][c];
        this.visited = new boolean[r][c];
        this.processed = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = -1;
                this.visited[i][j] = false;
                this.processed[i][j] = false;
            }
        }
        this.bfs(matrix, x, y);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValid(int[][] matrix, int x, int y){
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == -1 && !this.visited[x][y];
    }

    public void bfs(int[][] matrix, int x0, int y0) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] arr = { x0, y0, 0 };
        int[][] dir = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };
        queue.add(arr);
        this.visited[x0][y0] = true;
        while(!queue.isEmpty()){
            int[] front = queue.remove();
            int value = front[2];
            int x = front[0];
            int y = front[1];
            matrix[x][y] = value;
            processed[x][y] = true;
            // System.out.println("setting value for:" + x + ", " + y + ": " + value);
            for(int i=0;i<dir.length;i++){
                int[] d = dir[i];
                int x1 = x+d[0];
                int y1 = y+d[1];
                int[] el = {x1,y1,value+1};
                if(this.isValid(matrix, x1, y1)){
                    // System.out.println("adding to queque:" + x1 + " " + y1);
                    this.visited[x1][y1] = true;
                    queue.add(el);
                }
            }
        }
    }
} 
public class R5NumberWave {
    public static void main(String[] args) {
        int r, c, x, y;
        // int r=10, c=10, x=5, y=5;
        // int r=4, c=4, x=2, y=2;
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        Solution sol = new Solution();
        sol.printSolution(r, c, x, y);
        sc.close();
    }
}
