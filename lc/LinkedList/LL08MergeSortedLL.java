package lc.LinkedList;

public class LL08MergeSortedLL {
    public static void main(String[] args) {
        LL08Solution solution = new LL08Solution();

        ListNode[] example1 = new ListNode[3];
        example1[0] = ListNode.createLinkedList(new int[] {1,4,5});
        example1[1] = ListNode.createLinkedList(new int[] {1,3,4});
        example1[2] = ListNode.createLinkedList(new int[] {2,6});
        ListNode result1 = ListNode.createLinkedList(new int [] {1,1,2,3,4,4,5,6});
        assert result1.equals(solution.mergeKLists(example1));

        ListNode[] example2 = new ListNode[4];
        example2[0] = ListNode.createLinkedList(new int[] {1,2,3});
        example2[1] = ListNode.createLinkedList(new int[] {4,5,6});
        example2[2] = ListNode.createLinkedList(new int[] {});
        example2[3] = ListNode.createLinkedList(new int[] {-10,-1});
        ListNode result2 = ListNode.createLinkedList(new int [] {-10, -1, 1,2,3,4,5,6});
        assert result2.equals(solution.mergeKLists(example2));
    }
}

class LL08Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode finalList = null;
        ListNode currentNode = null;
        while(true) {
            int index = -1;
            int minValue = Integer.MAX_VALUE;
            for(int i=0;i<lists.length;i++) {
                if(lists[i] != null && lists[i].val < minValue) {
                    index = i;
                    minValue = lists[i].val;
                }
            }
            if(index == -1) {
                break;
            } else {
                ListNode chosenList = lists[index];
                ListNode node = new ListNode(chosenList.val);
                if(finalList == null) {
                    finalList = node;
                    currentNode = node;
                }else {
                    currentNode.next = node;
                    currentNode = node;
                }
                lists[index] = lists[index].next;
            }
        }
        return finalList;
    }
}
