package lc.LinkedList;
/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise
 */
public class LLE03PalindromeLinkedList {
    public static void main(String[] args) {
        LLE03Solution sol = new LLE03Solution();
        assert sol.isPalindrome(ListNode.createLinkedList(new int[] {1,2,2,1}));
        assert sol.isPalindrome(ListNode.createLinkedList(new int[] {1,2,2})) == false;
        assert sol.isPalindrome(ListNode.createLinkedList(new int[] {}));
    }
}

class LLE03Solution {
    private int[] list = new int[100_000];
    public boolean isPalindrome(ListNode head) {
        ListNode curentNode = head;
        int index = 0;
        while(curentNode != null) {
            list[index++] = curentNode.val;
            curentNode = curentNode.next;
        }
        int left = 0, right = index - 1;
        boolean result = true;
        while(left <= right) {
            if(list[right] != list[left]) {
                result = false;
                break;
            }
            left++;
            right--;
        }
        return result;
    }
}
