package  lc.recursion;
// https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/2378/

class SolutionRec03RevLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode[] reversedNodes = reverseListUtil(head);
        return reversedNodes[0];
    }
    public ListNode[] reverseListUtil(ListNode head){
        ListNode[] result = new ListNode[2];
        if(head.next == null){
            result[0] = head;
            result[1] = head;
            return result;
        }
        else {
            ListNode[] list = reverseListUtil(head.next);
            result[0]= list[0];
            list[1].next = head;
            result[1] = head;
            head.next = null;
            return result;
        }
    }
}
public class Rec03RevLinkedList {
    public static void printReversed(ListNode node){
        while(node != null){
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // example 1
        int[] listItems = {1,2,3,4,5};
        ListNode node = new ListNode(listItems[0]);
        ListNode currentNode = node;
        for(int i=1;i<listItems.length;i++){
            currentNode.next = new ListNode(listItems[i]);
            currentNode = currentNode.next;
        }

        SolutionRec03RevLinkedList sol = new SolutionRec03RevLinkedList();
        ListNode reverseList = sol.reverseList(node);
        printReversed(reverseList);
    }    
}
