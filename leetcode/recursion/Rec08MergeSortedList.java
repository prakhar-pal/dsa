// https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2382/


 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }else {
            ListNode nextNode;
            if(l1.val < l2.val){
                nextNode = mergeTwoLists(l1.next, l2);
                l1.next = nextNode;
                return l1;
            }else {
                nextNode = mergeTwoLists(l1, l2.next);
                l2.next = nextNode;
                return l2;
            }
        }
    }
}

class Rec08MergeSortedList {
    public static void printList(ListNode node){
        while(node != null){
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        ListNode list1 = new ListNode(1,
            new ListNode(2,
                new ListNode(4)));

        ListNode list2 = new ListNode(1,
        new ListNode(3,
        new ListNode(4)));
        Solution sol = new Solution();
        printList(sol.mergeTwoLists(list1, list2));
    }
}
