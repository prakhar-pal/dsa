// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
// trees, binary-search-trees
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
 var lowestCommonAncestor = function(root, p, q) {
     const find = (node, value, set) => {
         if(node === null) {
             return false;
         }
         if(value === node.val) {
             set.add(node);
             return true;
         }
         if(value < node.val) {
             const left = find(node.left, value, set);
             if(left) {
                 set.add(node);
             }
             return left;
         }
         if(value > node.val) {
             const right = find(node.right, value, set);
             if(right) {
                 set.add(node);
             }
             return right;
         }
       return false;
     }
     const pset = new Set();
     const qset = new Set();
     find(root, p.val, pset);
     find(root, q.val, qset);
     return [...pset.intersection(qset)][0];
 };

Set.prototype.intersection = function (otherSet) {
  const resultSet = new Set();
  for(let item of [...otherSet]) {
    if(this.has(item)) {
      resultSet.add(item);
    }
  }
  return resultSet;
}

function TreeNode(val) {
     this.val = val;
     this.left = this.right = null;
}
const rootNode = new TreeNode(6);
const left = new TreeNode(2);
rootNode.left = left;
const right = new TreeNode(8);
rootNode.right = right;

console.log(lowestCommonAncestor(rootNode, left, right)?.val);
