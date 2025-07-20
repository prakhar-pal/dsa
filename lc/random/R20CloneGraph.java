package lc.random;
import java.util.*;
import lc.utils.Clogger;

/**
 * https://leetcode.com/problems/clone-graph/description
 */
public class R20CloneGraph {
    public static void main(String[] args) {
        R20Solution solution = new R20SolutionTwo();

        R20CloneGraph r20CloneGraph = new R20CloneGraph();
        Node[] inputNodes1 = r20CloneGraph.createGraphFromAdjList(4, new int[][] {
            {1,2},
            {2,3},
            {3,4},
            {4,1},
            {1,3}
        });
        Node clonedNode1 = solution.cloneGraph(inputNodes1[0]);
        assert clonedNode1 != inputNodes1[0];
        Clogger.log("printing graph 1");
        r20CloneGraph.printAdjacencyList(clonedNode1);

        Node[] inputNodes2 = r20CloneGraph.createGraphFromAdjList(4, new int[][] {
            {2,4},
            {1,3},
            {2,4},
            {1,3},
        });
        Node clonedNode2 = solution.cloneGraph(inputNodes2[0]);
        assert clonedNode2 != inputNodes2[0];
    }

    private void printAdjacencyList(Node node) {
        Map<Integer, Set<Integer>> adjacencyList1 = this.createAdjacencyList(node);
        for(int key: adjacencyList1.keySet()) {
            Set<Integer> row = adjacencyList1.get(key);
            Clogger.logi("row="+key+"\t");
            for(int i: row) {
                Clogger.logi(i + "\t");
            }
            Clogger.lognl();
        }
    }

    private Node[] createGraphFromAdjList(int n, int[][] edges) {
        Node[] nodes = new Node[n];
        for(int i=0;i<n;i++) {
            nodes[i] = new Node(i+1);
        }
        for(int[] edge: edges) {
            int from = edge[0]-1;
            int to = edge[1]-1;
            nodes[from].neighbors.add(nodes[to]);
            nodes[to].neighbors.add(nodes[from]);
        }
        return nodes;
    }

    private Map<Integer, Set<Integer>> createAdjacencyList(Node node) {
        class AdjUtil {
            private void act(Node node, Map<Integer, Set<Integer>> list, Set<Integer> visited) {
                if(visited.contains(node.val)) {
                    return;
                }
                visited.add(node.val);
                Set<Integer> row = node.val - 1 < list.size() && list.get(node.val-1) != null ? list.get(node.val - 1) : new HashSet<>();
                for(Node n: node.neighbors) {
                    row.add(n.val);
                }
                for(Node n: node.neighbors) {
                    this.act(n, list, visited);
                }
                list.put(node.val-1, row);
            }
        };
        Map<Integer,Set<Integer>> list = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        AdjUtil util = new AdjUtil();
        util.act(node, list, visited);
        return list;
    }
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

interface R20Solution {
    public Node cloneGraph(Node node);
}

class R20SolutionOne implements R20Solution {
    HashMap<Integer, Node> clonedNodes;
    public Node cloneGraph(Node node) {
        clonedNodes = new HashMap<>();
        return cgUtil(node);
    }
    private Node cgUtil(Node node) {
        if(clonedNodes.containsKey(node.val)) {
            return clonedNodes.get(node.val);
        }
        Node clonedNode = new Node(node.val);
        List<Node> existing = new ArrayList<>();
        List<Node> nonExisting = new ArrayList<>();
        clonedNodes.put(node.val, clonedNode);
        for(Node neighbor: node.neighbors) {
            if(clonedNodes.containsKey(neighbor.val)) {
                existing.add(clonedNodes.get(neighbor.val));
            }else {
                nonExisting.add(neighbor);
            }
        }
        for(Node originalNode: nonExisting) {
            cgUtil(originalNode);
        }
        for(Node existingClonedNeighbor: existing) {
            existingClonedNeighbor.neighbors.add(node);
            node.neighbors.add(existingClonedNeighbor);
        }
        return clonedNode;
    }
}
/**
 * solution from
 * https://leetcode.com/problems/clone-graph/solutions/3393431/java-easy-solution-dfs-tc-o-n-sc-o-n/?envType=study-plan-v2&envId=top-interview-150
 */
class R20SolutionTwo implements R20Solution {
    HashMap<Integer, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        Node ans = new Node();
        if(node == null){
            return null;
        }
        ans.val = node.val;
        visited.put(node.val, ans);
        for(int i=0; i<node.neighbors.size(); i++){
            if(!visited.containsKey(node.neighbors.get(i).val)){
                cloneGraph(node.neighbors.get(i));
            }
        }

        for(int i=0; i<node.neighbors.size(); i++){
            Clogger.printf("setting %d as neighbor of %d\n", node.neighbors.get(i).val, ans.val);
            ans.neighbors.add(visited.get(node.neighbors.get(i).val));
        }
        return ans;
    }
}
