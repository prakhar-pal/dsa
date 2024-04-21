package lc.LinkedList;
import lc.ArraysAndStrings.ArrayUtils;
import java.util.*;

public class LLE02RemoveNthNode {
    public static void main(String[] args) {
        LLE02Solution sol = new LLE02Solution();

        ListNode head1 = sol.removeNthFromEnd(ListNode.createLinkedList(new int[] {1,2,3,4,5}), 2);
        assert ArrayUtils.isSame1DArray(ArrayUtils.listToArray(head1.toList()), new int[] {1,2,3,5});

        ListNode head2 = sol.removeNthFromEnd(ListNode.createLinkedList(new int[] {1}), 1);
        assert head2 == null;

        ListNode head3 = sol.removeNthFromEnd(ListNode.createLinkedList(new int[] {1,2}), 1);
        assert ArrayUtils.isSame1DArray(ArrayUtils.listToArray(head3.toList()), new int[] {1});

        ListNode head4 = sol.removeNthFromEnd(ListNode.createLinkedList(new int[] {1,2,3}), 1);
        assert ArrayUtils.isSame1DArray(ArrayUtils.listToArray(head4.toList()), new int[] {1,2});
    }
}

class LLE02Solution {
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
