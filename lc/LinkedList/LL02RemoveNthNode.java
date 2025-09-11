package lc.LinkedList;
import java.util.*;

import lc.utils.ArrayUtils;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class LL02RemoveNthNode {
    public static void main(String[] args) {
        LLE02Solution sol = new LLE02SolutionTwo();

        ListNode head1 = sol.removeNthFromEnd(ListNode.createLinkedList(new int[] {1,2,3,4,5}), 2);
        assert ArrayUtils.isSame1DArray(ArrayUtils.listToArray(head1.toList()), new Integer[] {1,2,3,5});

        ListNode head2 = sol.removeNthFromEnd(ListNode.createLinkedList(new int[] {1}), 1);
        assert head2 == null;

        ListNode head3 = sol.removeNthFromEnd(ListNode.createLinkedList(new int[] {1,2}), 1);
        assert ArrayUtils.isSame1DArray(ArrayUtils.listToArray(head3.toList()), new Integer[] {1});

        ListNode head4 = sol.removeNthFromEnd(ListNode.createLinkedList(new int[] {1,2,3}), 1);
        assert ArrayUtils.isSame1DArray(ArrayUtils.listToArray(head4.toList()), new Integer[] {1,2});
    }
}


interface LLE02Solution {
    public ListNode removeNthFromEnd(ListNode head, int n);
}

class LLE02SolutionOne {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode currentNode = head;
        while(currentNode != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        list.remove(list.size() - n);
        if(list.size() == 0) {
            return null;
        }
        ListNode newHead = new ListNode(list.get(0).val);
        ListNode prevNode = newHead;
        for(int i=1;i<list.size();i++) {
            prevNode.next = new ListNode(list.get(i).val);
            prevNode = prevNode.next;
        }
        return newHead;
    }
}


class LLE02SolutionTwo implements LLE02Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode currentNode = head;
        while(currentNode != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        int removalIndex = list.size() - n;
        if(removalIndex == 0) {
            if(list.size() > 1) {
                return list.get(1);
            }
            return null;
        }

        ListNode prevNode = list.get(removalIndex-1);
        if(removalIndex == list.size() - 1) {
            prevNode.next = null;
            return head;
        }
        ListNode nextNode = list.get(removalIndex+1);
        prevNode.next = nextNode;
        return head;
    }
}

class LLE02SolutionThree implements LLE02Solution {
    /**
     * single pass solution using window sliding
     * taken from submissions page
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i = 0; i < n; i++) fast = fast.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
