package lc.LinkedList;

import lc.recursion.ListNode;

class SolutionP0LinkedListCycle {
    public lc.recursion.ListNode getNextFastNode(lc.recursion.ListNode head) {
        if(head == null) return null;
        lc.recursion.ListNode nextNode = head.next;
        if(nextNode == null) return null;
        nextNode = nextNode.next;
        return nextNode;
    }
    public boolean hasCycle(lc.recursion.ListNode head) {
        lc.recursion.ListNode slowNode = head;
        lc.recursion.ListNode fastNode = getNextFastNode(head);
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

class SolutionP0LinkedListCycle2 {
    public boolean hasCycle(lc.recursion.ListNode head) {
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

public class LL04LinkedListCycle {
    public static void main(String[] args) {
        SolutionP0LinkedListCycle2 sol = new SolutionP0LinkedListCycle2();

        lc.recursion.ListNode list1 = new lc.recursion.ListNode(3);
        list1.next = new lc.recursion.ListNode(2);
        lc.recursion.ListNode repeatNode = list1.next;
        list1.next.next = new lc.recursion.ListNode(0);
        list1.next.next.next = new lc.recursion.ListNode(-4);
        assert sol.hasCycle(list1) == false;
        list1.next.next.next.next = repeatNode;
        assert sol.hasCycle(list1) == true;

        lc.recursion.ListNode l2node1 = new lc.recursion.ListNode(1);
        lc.recursion.ListNode l2node2 = new lc.recursion.ListNode(2);
        lc.recursion.ListNode l2node3 = new lc.recursion.ListNode(3);
        l2node1.next = l2node2;
        l2node2.next = l2node3;
        // l2node3.next = l2node1;
        assert sol.hasCycle(l2node1);
    }
}
