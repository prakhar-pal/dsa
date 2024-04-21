package lc.LinkedList;
import java.util.*;

 /**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public String toString() {
        String name = new String("");
        ListNode cn = this;
        while(cn != null) {
            name = name + cn.val + "-> ";
            cn = cn.next;
        }
        name = name + "null";
        name = name.trim();
        return name;
    }

    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        ListNode node = this;
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

    public static ListNode createLinkedList(int[] values) {
        if(values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode prevNode = head;
        for(int i=1;i<values.length;i++) {
            ListNode node = new ListNode(values[i]);
            prevNode.next = node;
            prevNode = node;
        }
        return head;
    }
}

