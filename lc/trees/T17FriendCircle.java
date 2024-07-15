package lc.trees;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/number-of-provinces/description/
 */
public class T17FriendCircle {
    public static void main(String[] args) {
        T17Solution solution = new T17Solution();

        // assert solution.findCircleNum(new int[][] {
        //     {1,1,0},
        //     {1,1,0},
        //     {0,0,1}
        // }) == 2;

        // assert solution.findCircleNum(new int[][] {
        //     {1,0,0},
        //     {0,1,0},
        //     {0,0,1}
        // }) == 3;

        // assert solution.findCircleNum(new int[][] {
        //     {1,0,1},
        //     {0,1,0},
        //     {1,0,1}
        // }) == 2;

        // assert solution.findCircleNum(new int[][] {
        //     {1,1,0,0},
        //     {1,1,0,0},
        //     {0,0,1,1},
        //     {0,0,1,1},
        // }) == 2;

        // assert solution.findCircleNum(new int[][] {
        //     {1,1,1,0},
        //     {1,1,0,0},
        //     {1,0,1,0},
        //     {0,0,0,1},
        // }) == 2;

        // assert solution.findCircleNum(new int[][] {
        //     {1,0,0,0},
        //     {0,1,1,0},
        //     {0,1,1,0},
        //     {0,0,0,1},
        // }) == 3;

        assert solution.findCircleNum(new int[][] {
            {1,0,0,1},
            {0,1,1,0},
            {0,1,1,1},
            {1,0,1,1},
        }) == 1;
    }
}

class T17Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        HashSet<Integer> visitorSet = new HashSet<>();
        int provinces = 0;
        for(int i=0;i<n;i++) {
            HashSet<Integer> newVisitors = new HashSet<>();
            if(visitorSet.contains(i)) {
                continue;
            }
            for(int j=0;j<n;j++) {
                if(i == j) {
                    continue;
                }
                if(isConnected[i][j] == 1) {
                    newVisitors.add(j);
                }
            }
            if(newVisitors.size() > 0) { 
                visitorSet.add(i);
                bfsVisit(isConnected, newVisitors, visitorSet);
                provinces++;
            }
        }
        provinces += n - visitorSet.size();
        return provinces;
    }
    private void bfsVisit(int[][] isConnected, HashSet<Integer> newVisitors, HashSet<Integer> alreadyVisited) {
        HashSet<Integer> nextVisitors = new HashSet<>();
        for(int row: newVisitors) {
            alreadyVisited.add(row);
            for(int j=0;j<isConnected.length;j++) {
                if(row == j || alreadyVisited.contains(j)) {
                    continue;
                }else if(isConnected[row][j] == 1) {
                    nextVisitors.add(j);
                }
            }
        }
        if(nextVisitors.size() > 0) {
            bfsVisit(isConnected, nextVisitors, alreadyVisited);
        }
    }
}
