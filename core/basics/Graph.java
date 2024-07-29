package core.basics;

import java.util.*;

public class Graph {
    int v; // vertices
    public List<HashSet<Integer>> adjList;
    public Graph(int v) {
        this.init(v);
    }
    private void init(int v) {
        this.v = v;
        adjList = new ArrayList<>();
        for(int i=0;i<v;i++) {
            adjList.add(new HashSet<>());
        }
    }
    public Graph(int v, int[][] edges) {
        this.init(v);
        for(int[] edge: edges) {
            this.addEge(edge[0], edge[1]);
        }
    }
    public void addEge(int u, int v) {
        this.adjList.get(u).add(v);
        this.adjList.get(v).add(u);
    }
}
