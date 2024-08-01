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
        Logger.log("bfs for graph 1");
        bfs.bfs(g1, 0);

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
        Logger.log("bfs for graph 2");
        bfs.bfs(g2, 0);
    }
    private void bfs(Graph g, int node) {
        boolean[] visited = new boolean[g.v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if(visited[n]) {
                continue;
            }
            visited[n] = true;
            Logger.log("visited " + n);
            for(int i: g.adjList.get(n)) {
                queue.add(i);
            }
        }
    }
}
