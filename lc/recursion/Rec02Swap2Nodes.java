package lc.recursion;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class SolutionRec02Swap2Nodes {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        else if(head != null && head.next == null) return head;
        else {
            ListNode current, next;
            current = head;
            next = head.next;
            current.next = swapPairs(head.next.next);
            next.next = current;
            return next;
        }
    }
}
public class Rec02Swap2Nodes {
    public static void printSwapped(ListNode node){
        while(node != null){
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // example 1
        // int[] listItems = {1,2,3,4};
        // ListNode node = new ListNode(listItems[0]);
        // ListNode currentNode = node;
        // for(int i=1;i<listItems.length;i++){
        //     currentNode.next = new ListNode(listItems[i]);
        //     currentNode = currentNode.next;
        // }

        // example 2
        // ListNode node = new ListNode(1);

        //example 3
        ListNode node = null;
        SolutionRec02Swap2Nodes sol = new SolutionRec02Swap2Nodes();
        ListNode newNode = sol.swapPairs(node);
        printSwapped(newNode);
    }
}
