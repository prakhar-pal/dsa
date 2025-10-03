package basics;

import java.util.*;

import lc.utils.Clogger;

public class GraphTraversal {
    private int method = 1; // use 0 for BFS, 1 for DFS
    public static void main(String[] args) {
        GraphTraversal traversal = new GraphTraversal();

        int nodeCount1 = 5;
        Graph g1 = new Graph(nodeCount1);
        g1.addEge(0, 1);
        g1.addEge(0, 2);
        g1.addEge(0, 3);
        g1.addEge(2, 3);
        g1.addEge(3, 4);
        Clogger.log("traversal for graph 1");
        traversal.travserse(g1, 3);

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
        Clogger.log("traversal for graph 2");
        traversal.travserse(g2, 3);
    }
    private void travserse(Graph g, int node) {
        if(method == 0) {
            Clogger.log("method=bfs");
            this.bfs(g, node);
        }else {
            Clogger.log("method=dfs");
            this.dfs(g, node);
        }
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
            Clogger.log("visited " + n);
            for(int i: g.adjList.get(n)) {
                queue.add(i);
            }
        }
    }
    private void dfs(Graph g, int node) {
        boolean[] visited = new boolean[g.v];
        dfs(g, node, visited);
    }
    private void dfs(Graph g, int node, boolean[] visited) {
        if(visited[node]) {
            return;
        }
        visited[node] = true;
        Clogger.log("visiting " + node);
        for(int n: g.adjList.get(node)) {
            dfs(g, n, visited);
        }
    }
}
