package lc.LinkedList;
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/784/
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

 * The first node is considered odd, and the second node is even, and so on.

 * Note that the relative order inside both the even and odd groups should remain as it was in the input.

 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */


public class LL06SortOddEven {
    public static boolean isSameLinkedList(ListNode list1, ListNode list2) {
        if(list1 == list2) {
            return true;
        }
        if(list1 == null || list2 == null) {
            return false;
        }
        if(list1.val != list2.val) {
            return false;
        }
        return LL06SortOddEven.isSameLinkedList(list1.next, list2.next);
    }

    public static ListNode createList(int[] arr) {
        if(arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cn = head;
        for(int i=1;i<arr.length;i++) {
            cn.next = new ListNode(arr[i]);
            cn = cn.next;
        }
        return head;
    }
    public static void main(String[] args) {
        LLP2Solution sol = new SolutionLLP2Fastest();

        assert LL06SortOddEven.isSameLinkedList(
            sol.oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))),
            new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(2, new ListNode(4)))))
        );

        assert LL06SortOddEven.isSameLinkedList(
            sol.oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))),
            new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(4))))
        );

        assert LL06SortOddEven.isSameLinkedList(
            sol.oddEvenList(null),
            null
        );


        assert LL06SortOddEven.isSameLinkedList(
            sol.oddEvenList(new ListNode(1)),
            new ListNode(1)
        );



        assert LL06SortOddEven.isSameLinkedList(
            sol.oddEvenList(new ListNode(1)),
            new ListNode(1)
        );

        assert LL06SortOddEven.isSameLinkedList(
            sol.oddEvenList(createList(new int[]{2,1,3,5,6,4,7})),
            createList(new int[]{2,3,6,7,1,5,4})
        );



        assert LL06SortOddEven.isSameLinkedList(
            sol.oddEvenList(createList(new int[]{1,2,3,4,5,6})),
            createList(new int[]{1,3,5,2,4,6})
        );
    }
}

interface LLP2Solution {
    public ListNode oddEvenList(ListNode head);
}

class SolutionLLP2Fastest implements LLP2Solution {
    // 0ms solution from leetcode
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddst=head;
        ListNode evenst=head.next;
        ListNode even=evenst;
        ListNode odd=oddst;
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenst;
        return oddst;
    }
}

class SolutionP2SortOddEvenSortOddEven implements LLP2Solution {
    public ListNode oddEvenList(ListNode head) {
        int index = 1;
        ListNode oddList = null, evenList = null, currentOddList = null, currentEvenList = null;
        ListNode currentNode = head;
        while(currentNode != null) {
            if(index % 2 == 1) {
                if(oddList == null) {
                    oddList = new ListNode(currentNode.val);
                    currentOddList = oddList;
                } else {
                    currentOddList.next = new ListNode(currentNode.val);
                    currentOddList = currentOddList.next;
                }
            } else {
                ListNode newNode = new ListNode(currentNode.val);
                if(evenList == null) {
                    evenList = newNode;
                    currentEvenList = evenList;
                } else {
                    currentEvenList.next = newNode;
                    currentEvenList = currentEvenList.next;
                }
            }
            currentNode = currentNode.next;
            index++;
        }
        if(oddList != null && evenList != null) {
            ListNode cn = oddList;
            while(cn.next != null) {
                cn = cn.next;
            }
            cn.next = evenList;
        }
        return oddList;
    }
}
