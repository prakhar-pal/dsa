package lc.trees;

import java.util.HashSet;
import java.util.Objects;

import lc.ArraysAndStrings.ArrayUtils;

public class T15SurroundedRegions {
    public static void main(String[] args) {
        T15Solution solution = new T15Solution();

        char[][] inputMatrix1 = new char[][] {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        char[][] outputMatrix1 = new char[][] {
            {'X','X','X','X'},
            {'X','X','X','X'},
            {'X','X','X','X'},
            {'X','O','X','X'}
        };
        solution.solve(inputMatrix1);
        assert ArrayUtils.isSame2DArray(inputMatrix1, outputMatrix1);

        char[][] inputMatrix2 = new char[][] {
            {'X'}
        };
        char[][] outputMatrix2 = new char[][] {
            {'X'}
        };
        solution.solve(inputMatrix2);
        assert ArrayUtils.isSame2DArray(inputMatrix2, outputMatrix2);

        char[][] inputMatrix3 = new char[][] {
            {'O','O','O','O','X','X'},
            {'O','O','O','O','O','O'},
            {'O','X','O','X','O','O'},
            {'O','X','O','O','X','O'},
            {'O','X','O','X','O','O'},
            {'O','X','O','O','O','O'}
        };
        char[][] outputMatrix3 = new char[][] {
            {'O','O','O','O','X','X'},
            {'O','O','O','O','O','O'},
            {'O','X','O','X','O','O'},
            {'O','X','O','O','X','O'},
            {'O','X','O','X','O','O'},
            {'O','X','O','O','O','O'}
        };
        solution.solve(inputMatrix3);
        assert ArrayUtils.isSame2DArray(inputMatrix3, outputMatrix3);

        char[][] inputMatrix4 = new char[][] {
            {'O', 'X', 'O'},
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
        };
        char[][] outputMatrix4 = new char[][] {
            {'O', 'X', 'O'},
            {'X', 'X', 'X'},
            {'O', 'X', 'O'},
        };
        solution.solve(inputMatrix4);
        assert ArrayUtils.isSame2DArray(inputMatrix4, outputMatrix4);

        char[][] inputMatrix5 = new char[][] {
            {'O','X','O','O','X','X'},
            {'O','X','X','X','O','X'},
            {'X','O','O','X','O','O'},
            {'X','O','X','X','X','X'},
            {'O','O','X','O','X','X'},
            {'X','X','O','O','O','O'}
        };
        char[][] outputMatrix5 = new char[][] {
            {'O','X','O','O','X','X'},
            {'O','X','X','X','O','X'},
            {'X','O','O','X','O','O'},
            {'X','O','X','X','X','X'},
            {'O','O','X','O','X','X'},
            {'X','X','O','O','O','O'}
        };
        solution.solve(inputMatrix5);
        assert ArrayUtils.isSame2DArray(inputMatrix5, outputMatrix5);
    }
}

class MatrixIndex {
    public int[] arr;
    public MatrixIndex(int a, int b) {
        arr = new int[2];
        arr[0] = a;
        arr[1] = b;
    }

    public int getFirst() {
        return arr[0];
    }

    public int getSecond() {
        return arr[1];
    }
    @Override
    public boolean equals(Object _pair2) {
        if(_pair2 instanceof MatrixIndex) {
            MatrixIndex pair2 = (MatrixIndex) _pair2;
            return this.getFirst() == pair2.getFirst() && this.getSecond() == pair2.getSecond();
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(arr[0], arr[1]);
    }
}

class T15Solution {
    public void solve(char[][] board) {
        HashSet<MatrixIndex> prevPairSet = new HashSet<>();
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == 'O' && !prevPairSet.contains(new MatrixIndex(i, j))) {
                    HashSet<MatrixIndex> pairSet = new HashSet<>();
                    bfs(board, i, j, pairSet);
                    boolean isRegionOnTheBorder = false;
                    for(MatrixIndex p: pairSet) {
                        int row = p.getFirst();
                        int col = p.getSecond();
                        if(row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1) {
                            isRegionOnTheBorder = true;
                            break;
                        }
                    }
                    if(isRegionOnTheBorder == false) {
                        for(MatrixIndex p: pairSet) {
                            int row = p.getFirst();
                            int col = p.getSecond();
                            board[row][col] = 'X';
                        }
                    }
                    prevPairSet.addAll(pairSet);
                }
            }
        }
    }
    private void bfs(char[][] board, int i, int j, HashSet<MatrixIndex> set) {
        if(i< 0 || i>= board.length || j < 0 || j >= board[0].length || set.contains(new MatrixIndex(i, j)) || board[i][j] == 'X') {
            return;
        }
        MatrixIndex pair = new MatrixIndex(i, j);
        set.add(pair);
        bfs(board, i+1, j, set);
        bfs(board, i-1, j, set);
        bfs(board, i, j+1, set);
        bfs(board, i, j-1, set);
    }
}
