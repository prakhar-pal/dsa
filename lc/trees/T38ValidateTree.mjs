// https://neetcode.io/problems/valid-tree/question?list=neetcode150

import assert from "assert";

// trees, graph
class Solution {
    /**
     * @param {number} n
     * @param {number[][]} edges
     * @returns {boolean}
     */
    validTree(n, edges) {
        const adj = Array.from({ length: n }, () => []);
        // const visited = Array.from({ length: n }, () => false);
        for(const [u, v] of edges) {
            adj[u].push(v);
            adj[v].push(u);
        }

        function dfs(i, parent, set) {
            if(set.has(i)) {
                return false;
            }
            set.add(i);
            for(let j of adj[i]) {
                if(j === parent) {
                    continue;
                }
                if(dfs(j, i, set) === false) {
                    return false;
                }
            }
            return true;
        }
        const visitedEdges = new Set();
        return dfs(0, -1, visitedEdges) && visitedEdges.size === n;
    }
}


const solution = new Solution();
assert(solution.validTree(5, [[0, 1], [0, 2], [0, 3], [1, 4]]) === true);
assert(solution.validTree(5, [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]) === false);
