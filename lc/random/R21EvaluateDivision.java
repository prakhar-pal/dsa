package lc.random;
import lc.ArraysAndStrings.*;
import java.util.*;

/**
 * https://leetcode.com/problems/evaluate-division/
 */
public class R21EvaluateDivision {
    public static void main(String[] args) {
        R21Solution solution = new R21Solution();

        double[] result1 = solution.calcEquation(ArrayUtils.createList(new String[][] { { "a", "b" }, { "b", "c" } }),
                new double[] { 2.0, 3.0 }, ArrayUtils.createList(
                        new String[][] { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } }));
        assert ArrayUtils.isSame1DArray(Arrays.stream(result1).boxed().toArray(Double[]::new),
                new Double[] { 6.00000, 0.50000, -1.00000, 1.00000, -1.00000 });

        double[] result2 = solution.calcEquation(
                ArrayUtils.createList(new String[][] { { "a", "b" }, { "b", "c" }, { "bc", "cd" } }),
                new double[] { 1.5, 2.5, 5.0 },
                ArrayUtils.createList(new String[][] { { "a", "c" }, { "c", "b" }, { "bc", "cd" }, { "cd", "bc" } }));
        assert ArrayUtils.isSame1DArray(Arrays.stream(result2).boxed().toArray(Double[]::new),
                new Double[] { 3.75000, 0.40000, 5.00000, 0.20000 });

        double[] result3 = solution.calcEquation(
                ArrayUtils.createList(new String[][] { { "a", "b" }, { "a", "c" } }),
                new double[] { 2.0, 4.0 },
                ArrayUtils.createList(new String[][] { { "c", "b" }}));
        assert ArrayUtils.isSame1DArray(Arrays.stream(result3).boxed().toArray(Double[]::new),
                new Double[] { 0.5 });
    }
}

class R21Solution {
    class Node {
        String value;
        Set<Edge> edges;
        public Node(String value) {
            this.value = value;
            edges = new HashSet<>();
        }
        public void addEdge(Edge edge) {
            this.edges.add(edge);
        }
    }
    class Edge {
        Node to, from;
        double weight;
        public Edge(Node from, Node to, double weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }
        public double getWeight(Node n) {
            if(n == from) {
                return weight;
            }
            return 1/weight;
        }
        public Node getOtherNode(Node n) {
            if(n == from) {
                return to;
            }
            return from;
        }
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, Node> nodes = new HashMap<>();
        // Set<Edge> edges = new HashSet<>();
        for(int i=0;i<equations.size();i++) {
            List<String> equation = equations.get(i);
            Node a = nodes.getOrDefault(equation.get(0), new Node(equation.get(0)));
            Node b = nodes.getOrDefault(equation.get(1), new Node(equation.get(1)));
            Edge e = new Edge(a, b, values[i]);
            a.addEdge(e);
            b.addEdge(e);
            nodes.put(equation.get(0), a);
            nodes.put(equation.get(1), b);
        }
        int index = 0;
        for(List<String> query: queries) {
            double queryResult = -1.0;
            try {
                Node a = nodes.get(query.get(0));
                Node b = nodes.get(query.get(1));
                Set<String> visited = new HashSet<>();
                queryResult = dfs(a, b, visited, 1.0);
            } catch (Exception e) {
                queryResult = -1.0;
            }
            result[index++] = queryResult;
        }
        return result;
    }

    private double dfs(Node a, Node b, Set<String> visited, double result) {
        if(visited.contains(a.value)) {
            return -1.0;
        }
        if(a.equals(b)) {
            return result;
        }
        visited.add(a.value);
        for(Edge edge: a.edges) {
            double newResult = dfs(edge.getOtherNode(a), b, visited, result * edge.getWeight(a));
            if(newResult != -1.0) {
                return newResult;
            }
        }
        return -1.0;
    }
}
