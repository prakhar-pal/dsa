package lc.trees;
import java.util.LinkedList;
import java.util.Queue;

class T27DetectBipartiteGraph {
  public static void main(String[] args) {
    T27Solution sol = new T27Solution();
    assert sol.isBipartite(new int[][] {{1,2,3},{0,2},{0,1,3},{0,2}}) == false;
    assert sol.isBipartite(new int[][] {{1,3},{0,2},{1,3},{0,2}}) == true;
    assert sol.isBipartite(new int[][] { { 1 }, { 0, 3 }, { 3 }, { 1, 2 } }) == true;
  }

}

class T27Solution {
  int[] state;

  public boolean isBipartite(int[][] graph) {
    state = new int[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (state[i] == 0 && bfs(graph, i) == false) {
        return false;
      }
    }
    return true;
  }

  private boolean bfs(int[][] graph, int i) {
    Queue<Integer> q = new LinkedList<>();
    q.add(i);
    state[i] = 1;
    while (!q.isEmpty()) {
      int item = q.poll();
      for (int nei : graph[item]) {
        if (state[item] == state[nei]) {
          // in the same group
          return false;
        }
        if(state[nei] == 0) {
          // vertex hasn't been visited
          q.add(nei);
          state[nei] = -1 * state[item];
        }
      }
    }
    return true;
  }
}
