/**
 * Definition for singly-linked list.
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getNextFastNode(ListNode head) {
        if(head == null) return null;
        ListNode nextNode = head.next;
        if(nextNode == null) return null;
        nextNode = nextNode.next;
        return nextNode;
    }
    public boolean hasCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = getNextFastNode(head);
        while(fastNode != null && slowNode != null && slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = getNextFastNode(fastNode);
        }
        if(fastNode == null || slowNode == null) {
            return false;
        }
        return true;
    }
}

class Solution2 {
    public boolean hasCycle(ListNode head) {
        ListNode turtle = head,hare = head;
        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
            if(turtle == hare){
                return true;
            }
        }
        return false;
    }
}

public class P0LinkedListCycle {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        ListNode list1 = new ListNode(3);
        list1.next = new ListNode(2);
        ListNode repeatNode = list1.next;
        list1.next.next = new ListNode(0);
        list1.next.next.next = new ListNode(-4);
        assert sol.hasCycle(list1) == false;
        list1.next.next.next.next = repeatNode;
        assert sol.hasCycle(list1) == true;

        ListNode l2node1 = new ListNode(1);
        ListNode l2node2 = new ListNode(2);
        ListNode l2node3 = new ListNode(3);
        l2node1.next = l2node2;
        l2node2.next = l2node3;
        // l2node3.next = l2node1;
        assert sol.hasCycle(l2node1);
    }
}
