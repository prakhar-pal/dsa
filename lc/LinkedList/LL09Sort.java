package lc.LinkedList;
import java.util.*;

/**
 * https://leetcode.com/problems/sort-list/description/
 * Given the head of a linked list, return the list after sorting it in ascending order.
 */
public class LL09Sort {
    public static void main(String[] args) {
        LL09Solution solution = new LL09SolutionTwo();
        assert solution.sortList(ListNode.createLinkedList(new int[] {4,2,1,3})).equals(ListNode.createLinkedList(new int[] {1,2,3,4}));
        assert solution.sortList(ListNode.createLinkedList(new int[] {-1,5,3,4,0})).equals(ListNode.createLinkedList(new int[] {-1,0,3,4,5}));
        assert solution.sortList(ListNode.createLinkedList(new int[] {})) == null;
    }
}

interface LL09Solution {
    public ListNode sortList(ListNode head);
}

class LL09SolutionOne implements LL09Solution{
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        Collections.sort(list);
        if(list.size() == 0) {
            return null;
        }
        ListNode sorted = new ListNode();
        node = sorted;
        for(int i: list) {
            ListNode ln = new ListNode(i);
            node.next = ln;
            node = ln;
        }
        return sorted.next;
    }
}


class LL09SolutionTwo implements LL09Solution{
    public ListNode sortList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(head == slow) {
            if(head != null && head.next != null && head.val > head.next.val) {
                int temp = head.val;
                head.val = head.next.val;
                head.next.val = temp;
            }
            return head;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(next);
        ListNode temp = new ListNode();
        ListNode newList = temp;
        while(left != null && right != null) {
            if(left.val < right.val) {
                newList.next = new ListNode(left.val);
                left = left.next;
            }else {
                newList.next = new ListNode(right.val);
                right = right.next;
            }
            newList = newList.next;
        }
        if(left != null) {
            newList.next = left;
        }
        if(right != null) {
            newList.next = right;
        }
        return temp.next;
    }
}
