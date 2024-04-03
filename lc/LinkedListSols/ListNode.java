package lc.LinkedListSols;

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
}

