package lc.ArraysAndStrings;

import java.util.HashMap;

public class A18LongestConsecutiveSeq {
    public static void main(String[] args) {
        A18Solution solution = new A18Solution();
        assert solution.longestConsecutive(new int[] {100,4,200,1,3,2}) == 4;
        assert solution.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}) == 9;
    }
}

class NumberNode {
    public int value;
    public NumberNode next;
    public NumberNode(int value) {
        this.value = value;
        this.next = null;
    }
}
class A18Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, NumberNode> nodeMap = new HashMap<>();
        int length = 0;
        for(int n:nums) {
            if(!nodeMap.containsKey(n)) {
                NumberNode nn = new NumberNode(n);
                nodeMap.put(n, nn);
                if(nodeMap.containsKey(n-1)) {
                    nodeMap.get(n-1).next = nn;
                }
                if(nodeMap.containsKey(n+1)) {
                    nn.next = nodeMap.get(n+1);
                }
            }
        }
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for(int key: nodeMap.keySet()) {
            if(visited.get(key) == null) {
                System.out.println("visiting "+key);
                int newLength = 0;
                NumberNode node = nodeMap.get(key);
                while(node != null) {
                    newLength++;
                    visited.put(node.value, true);
                    node = node.next;
                }
                length = Math.max(length, newLength);
            }
        }
        System.out.println();
        return length;
    }
}
