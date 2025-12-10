import assert from "assert";
// https://leetcode.com/problems/clone-graph/
// tree, graph
/**
 * // Definition for a _Node.
 * function _Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function(node, map = new Map()) {
    if(node === null) {
        return null;
    }
    if(map.has(node.val)) {
        return map.get(node.val);
    }
    const neighbors = node.neighbors.map(nei => cloneGraph(nei));
    const newNode = new Node(node.val, neighbors);
    map.set(node.val, newNode);
    return newNode;
};

function Node(val, neighbors) {
    this.val = val === undefined ? 0 : val;
    this.neighbors = neighbors === undefined ? [] : neighbors;
};

/**
 * 
 * @param {Array]} edges 
 */
function createGraph(edges) {
    const map = new Map();

    function getNode(val){
        return map.get(val) ?? new Node(val);
    }
    for(let edge of edges) {
        const [v0, v1] = edge;
        const n0 = getNode(val);
        const n1 = getNode(val);
        n1.neighbors.push(v0);
        n0.neighbors.push(v1);
    }
    // return map
}

function nodeSet(node, set = new Set()) {
    if(!set.has(node.val)) {
        set.add(node.val);
        for(let nei of node.neighbors) {
            nodeSet(nei, set);
        }
    }
    return set;
}

// test 1

let left = new Node(2);
let right = new Node(3);
let root = new Node(1, [left, right]);
const rootClone = cloneGraph(root);
assert(root !== rootClone);
console.log(nodeSet(rootClone));
console.log(nodeSet(root));
