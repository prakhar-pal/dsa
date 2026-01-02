// https://leetcode.com/problems/binary-tree-right-side-view/
// binary-tree, graph-traversal
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
    const values = [];
    let maxHeight = -1;
    function rsvUtil(node, height) {
        if(node === null) {
            return;
        }
        if(height > maxHeight) {
            maxHeight = height;
            values.push(node.val);
        }
        rsvUtil(node.right, height + 1);
        rsvUtil(node.left, height + 1);
    }
    rsvUtil(root, 0);
    return values;
};
