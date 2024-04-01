
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class P1AddTwoNums {
    public static boolean isSameLinkedList(ListNode list1, ListNode list2) {
        if(list1 == list2) {
            return true;
        }
        if(list1 == null || list2 == null) {
            System.out.println("either of the list are null, list1=" + list1 + ", list2=" + list2);
            return false;
        }
        if(list1.val != list2.val) {
            System.out.println("list valuesdon't match");
            return false;
        }
        return isSameLinkedList(list1.next, list2.next);
    }
    public static void main(String[] args){
        SolutionAdd2Nums sol = new SolutionAdd2Nums();

        ListNode result1 = sol.addTwoNumbers(
            new ListNode(1),
            new ListNode(0));
        assert isSameLinkedList(result1, new ListNode(1));


        ListNode result2 = sol.addTwoNumbers(
            new ListNode(0),
            new ListNode(1));
        assert isSameLinkedList(result2, new ListNode(1));


        ListNode result3 = sol.addTwoNumbers(
            new ListNode(4, new ListNode(6)),
            new ListNode(6, new ListNode(3)));
        assert isSameLinkedList(result3, new ListNode(0, new ListNode(0, new ListNode(1))));


        ListNode result4 = sol.addTwoNumbers(
            new ListNode(4, new ListNode(6)),
            new ListNode(6, new ListNode(3, new ListNode(1))));
        assert isSameLinkedList(result4, new ListNode(0, new ListNode(0, new ListNode(2))));

        ListNode result5 = sol.addTwoNumbers(
            new ListNode(4, new ListNode(6)),
            new ListNode(6, new ListNode(3, new ListNode(9))));
        assert isSameLinkedList(result5, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1)))));


        ListNode result6 = sol.addTwoNumbers(
            new ListNode(2, new ListNode(4, new ListNode(3))),
            new ListNode(5, new ListNode(6, new ListNode(4))));
        assert isSameLinkedList(result6, new ListNode(7, new ListNode(0, new ListNode(8))));


        ListNode result7 = sol.addTwoNumbers(
            new ListNode(0),
            new ListNode(0));
        assert isSameLinkedList(result7, new ListNode(0));

        ListNode result8 = sol.addTwoNumbers(
            new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
            new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        assert isSameLinkedList(result8, new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1)))))))));
    }
}

class SolutionAdd2Nums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = l1.val + l2.val;
        int remainder = value/10;
        ListNode node = new ListNode(value % 10);
        l1 = l1.next;
        l2 = l2.next;
        ListNode currentNode = node;
        while(l1 != null || l2 != null || remainder != 0) {
            value = remainder + (l1 != null ? l1.val: 0) + (l2 != null ? l2.val: 0);
            remainder = value/10;
            value = value % 10;
            ListNode nextNode = new ListNode(value);
            currentNode.next = nextNode;
            currentNode = nextNode;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        return node;
    }
}
