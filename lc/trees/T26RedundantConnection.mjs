// https://leetcode.com/problems/redundant-connection/description/
/**
 * @param {number[][]} edges
 * @return {number[]}
 */
var findRedundantConnection = function(edges) {

    /**
     * @param {Number} current 
     * @param {Number} previous 
     * @param {Set<Number>} visited 
     */
   function dfs(u, parent, visited) {
        if (visited.has(u)) return false;

        visited.add(u);

        for (const v of adj[u]) {
            if (v === parent) continue;
            if (!dfs(v, u, visited)) return false;
        }
        return true;
    }

    const n = edges.length;
    const adj = Array.from({ length: n + 1 }, () => new Set());
    for(let edge of edges) {
        const [u, v] = edge;
        adj[u].add(v);
        adj[v].add(u);
    }
    for(let edge of [...edges].reverse()) {
        const [u, v] = edge;
        adj[u].delete(v);
        adj[v].delete(u);
        const visited = new Set();
        if(dfs(1, -1, visited) && visited.size === n) {
            return edge;
        }
        adj[u].add(v);
        adj[v].add(u);
    }
    return null;
};

console.log(findRedundantConnection([[1,2],[1,3],[2,3]]));
console.log(findRedundantConnection([[1,2],[2,3],[3,4],[1,4],[1,5]]));
console.log(findRedundantConnection([[2,7],[7,8],[3,6],[2,5],[6,8],[4,8],[2,8],[1,8],[7,10],[3,9]]));
