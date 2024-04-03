package lc.LinkedListSols;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 */
public class P3Intersection {
    // public ListNode reverseList(ListNode head) {
    //     ListNode prevNode = null;
    //     ListNode currentNode = head;
    //     while(currentNode != null) {
    //         ListNode next = currentNode.next;
    //         currentNode.next = prevNode;
    //         prevNode = currentNode;
    //         currentNode = next;
    //     }
    //     return prevNode;
    // }
    public static boolean isSameLinkedList(ListNode list1, ListNode list2) {
        System.out.println("comparing: list1=" + list1 + ", list2=" + list2);
        if(list1 == list2) {
            return true;
        }
        if(list1 == null || list2 == null) {
            return false;
        }
        if(list1.val != list2.val) {
            return false;
        }
        return isSameLinkedList(list1.next, list2.next);
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

    public static void makeIntersectedList(ListNode headA, ListNode headB, ListNode intersectHead) {
        while(headA.next != null) {
            headA = headA.next;
        }
        headA.next = intersectHead;
        while(headB.next != null) {
            headB = headB.next;
        }
        headB.next = intersectHead;
    }
    public static void main(String[] args) {
        P3IntersectionFasterSolution sol = new P3IntersectionFasterSolution();

        // assert isSameLinkedList(sol.reverseList(createList(new int[]{1,2,3})), createList(new int[] {3,2,1}));

        // assert isSameLinkedList(sol.reverseList(null), null);

        // assert sol.getIntersectionNode(null, null) == null;

        ListNode headA1 = createList(new int[]{1,2});
        ListNode headB1 = createList(new int[]{1,2,3});
        makeIntersectedList(headA1, headB1, createList(new int[] {1,2,3}));
        assert isSameLinkedList(
            sol.getIntersectionNode(
                headA1,
                headB1
            ),
            createList(new int[]{1})
        );



        ListNode headA2 = createList(new int[]{4,1});
        ListNode headB2 = createList(new int[] {5,6,1});
        makeIntersectedList(headA2, headB2, createList(new int[] {8,4,5}));
        assert isSameLinkedList(
            sol.getIntersectionNode(
                headA2,
                headB2
            ),
            createList(new int[]{8})
        );
        ListNode t = new ListNode(1);
        HashSet<ListNode> st = new HashSet<>();
        st.add(t);
        assert st.contains(t);
    }
}

class P3IntersectionSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode commonNode = null;
        while(headA != null || headB != null) {
            if(headA != null) {
                if(set.contains(headA)) {
                    commonNode = new ListNode(headA.val);
                    break;
                }
                set.add(headA);
                headA = headA.next;
            }
            if(headB != null) {
                if(set.contains(headB)) {
                    commonNode = new ListNode(headB.val);
                    break;
                }
                set.add(headB);
                headB = headB.next;
            }
        }
        return commonNode;
    }
}

class P3IntersectionFasterSolution {
    /**
     * it's like two pointer
     */

     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        
        while(currA != currB){
            currA = currA == null? headB : currA.next;
            currB = currB == null? headA : currB.next;
        }
        
        return currA;
    }
}
