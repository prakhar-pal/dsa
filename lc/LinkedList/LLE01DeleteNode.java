package lc.LinkedList;
import lc.ArraysAndStrings.ArrayUtils;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * 
 * There is a singly-linked list head and we want to delete a node node in it.
 * You are given the node to be deleted node. You will not be given access to the first node of head.
 * All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
 * Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
 *  The value of the given node should not exist in the linked list.
 *  The number of nodes in the linked list should decrease by one.
 *  All the values before node should be in the same order.
 *  All the values after node should be in the same order.
 */
public class LLE01DeleteNode {
    public static void main(String[] args) {
        LLE01Solution sol = new LLE01Solution();

        ListNode list1 = ListNode.createLinkedList(new int[] {4,5,1,9});
        sol.deleteNode(list1.next);
        assert ArrayUtils.isSame1DArray(ArrayUtils.listToArray(list1.toList()), new int[] {4,1,9});


        ListNode list2 = ListNode.createLinkedList(new int[] {4,5,1,9});
        sol.deleteNode(list2.next.next);
        assert ArrayUtils.isSame1DArray(ArrayUtils.listToArray(list2.toList()), new int[] {4,5,9});
    }
}


class LLE01Solution {
    public void deleteNode(ListNode node) {
        ListNode child = node.next;
        ListNode gChild = child.next;
        node.val = child.val;
        node.next = gChild;
    }
}
