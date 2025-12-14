// https://leetcode.com/problems/reverse-nodes-in-k-group/
// linked-list, revese-nodes-in-k-group
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
    let node = head;
    const nodes = [];
    while(node !== null) {
        const tempNodes = [];
        while(tempNodes.length!==k && node) {
            tempNodes.push(node);
            node = node.next;
        }
        nodes.push(...(tempNodes.length === k ? tempNodes.reverse() : tempNodes));
    }
    for(let i=1;i<nodes.length;i++) {
        nodes[i-1].next = nodes[i];
    }
    nodes[nodes.length-1].next = null;
    return nodes[0];
};
