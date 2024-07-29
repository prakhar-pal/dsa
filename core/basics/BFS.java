package core.basics;

import java.util.*;

import lc.utils.Logger;

public class BFS {
    public static void main(String[] args) {
        BFS bfs = new BFS();

        int nodeCount1 = 5;
        Graph g1 = new Graph(nodeCount1);
        g1.addEge(0, 1);
        g1.addEge(0, 2);
        g1.addEge(0, 3);
        g1.addEge(2, 3);
        g1.addEge(3, 4);
        boolean[] visited1 = new boolean[nodeCount1];
        Logger.log("bfs for graph 1");
        bfs.bfs(g1, 0, visited1);

        int[][] edges2 = new int[][] {
            {0,1},
            {0,2},
            {1,3},
            {1,4},
            {2,5},
            {2,6}
        };
        int nodeCount2 = 7;
        Graph g2 = new Graph(nodeCount2, edges2);
        boolean[] visited2 = new boolean[nodeCount2];
        Logger.log("bfs for graph 2");
        bfs.bfs(g2, 0, visited2);
    }
    private void bfs(Graph g, int node, boolean[] visited) {
        if(visited[node]) {
            return;
        }
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        for(int i: g.adjList.get(node)) {
            if(!visited[i]) {
                Logger.log("visited " + i);
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int newNode = queue.poll();
            bfs(g, newNode, visited);
        }
    }
}
