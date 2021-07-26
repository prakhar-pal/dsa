import java.util.Scanner;

public class R5NumberWave {
    public static void main(String[] args) {
        int r, c, x, y;
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = -1;
            }
        }
        R5NumberWave.dfs(matrix, x, y, 0);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int[][] matrix, int x, int y, int value) {
        if (matrix[x][y] != 1) {
            matrix[x][y] = value;
            if (x > 0)
                R5NumberWave.dfs(matrix, x - 1, y, value + 1);
            if (x + 1 < matrix[0].length - 1)
                R5NumberWave.dfs(matrix, x + 1, y, value + 1);
            if (y - 1 >= 0)
                R5NumberWave.dfs(matrix, x, y - 1, value + 1);
            if (y + 1 < matrix.length)
                R5NumberWave.dfs(matrix, x, y + 1, value + 1);
        }
    }
}
