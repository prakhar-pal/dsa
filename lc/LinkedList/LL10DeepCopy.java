package lc.LinkedList;

import java.util.*;

import lc.utils.Logger;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 */
public class LL10DeepCopy {
    public static void main(String[] args) {
        LL10Solution solution = new LL10Solution();

        Node head = createListFromArray(new Integer[][] {
            {7,null},{13,0},{11,4},{10,2},{1,0}
        });
        Node result = solution.copyRandomList(head);
        while(result != null) {
            Logger.printf("[%d %d]", result.val, result.random != null ? result.random.val : null);
            result = result.next;
        }
        Logger.lognl();
    }

    public static Node createListFromArray(Integer[][] arr) {
        Node head = new Node(0);
        Node currentNode = head;
        List<Node> list = new ArrayList<>();
        for(Integer[] nodeInfo: arr) {
            Node node = new Node(nodeInfo[0]);
            list.add(node);
            currentNode.next = node;
            currentNode = node;
        }
        for(int i = 0;i<arr.length;i++) {
            Integer randomIndex = arr[i][1];
            if(randomIndex != null) {
                list.get(i).random = list.get(randomIndex);
            } 
        }
        return head.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class LL10Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Integer> nodeToIndex = new HashMap<>();
        int size = 0;
        Node current = head;
        while(current != null) {
            nodeToIndex.put(current, size++);
            current = current.next;
        }
        Integer[][] creationMatrix = new Integer[size][2];
        current = head;
        for(int i=0;i<size;i++) {
            creationMatrix[i][0] = current.val;
            creationMatrix[i][1] = current.random != null ? nodeToIndex.get(current.random): null;
            current = current.next;
        }
        Node newHead = new Node(0);
        current = newHead;
        Node[] list = new Node[size];
        for(int i=0;i<creationMatrix.length;i++) {
            Node node = new Node(creationMatrix[i][0]);
            list[i] = node;
            current.next = node;
            current = current.next;
        }
        current = newHead.next;
        for(int i=0;i<creationMatrix.length;i++) {
            if(creationMatrix[i][1] != null) {
                current.random = list[creationMatrix[i][1]];
            }
            current = current.next;
        }
        return newHead.next;
    }
}
