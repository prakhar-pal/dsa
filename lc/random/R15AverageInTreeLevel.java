package lc.random;

import lc.trees.*;
import java.util.*;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree
 */
public class R15AverageInTreeLevel {
    public static void main(String[] args) {
        R15Solution solution = new R15Solution();

        Integer[] arr1 = new Integer[] {
            3, 9, 20, null, null, 15, 7
        };
        List<Integer> list1 = new ArrayList<>();
        for(Integer i:arr1) {
            list1.add(i);
        }
        TreeNode tree1 = TreeNode.createTree(list1);
        List<Double> result1 = List.of(3.00000, 14.50000, 11.00000);
        assert solution.averageOfLevels(tree1).equals(result1);

        Integer[] arr2 = new Integer[] {3, 9, 20, null, null, 15, 7};
        List<Integer> list2 = new ArrayList<>();
        for(Integer i: arr2) {
            list2.add(i);
        }
        TreeNode tree2 = TreeNode.createTree(list2);
        List<Double> result2 = List.of(3.00000, 14.50000, 11.00000);
        assert solution.averageOfLevels(tree2).equals(result2);
    }
}

class R15Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<TreeNode> firstLevel = new ArrayList<>();
        if(root != null) {
            firstLevel.add(root);
        }
        averageOfLevels(firstLevel, result);
        return result;
    }
    private void averageOfLevels(List<TreeNode> nodes, List<Double> resultList) {
        List<TreeNode> nextLevel = new ArrayList<>();
        int count = 0;
        double sum = 0;
        for(TreeNode node: nodes) {
            sum += node.val;
            count++;
            if(node.left != null) {
                nextLevel.add(node.left);
            }
            if(node.right != null) {
                nextLevel.add(node.right);
            }
        }
        if(count > 0) {
            double average = sum / count;
            resultList.add(average);
        }
        if(nextLevel.size() > 0) {
            averageOfLevels(nextLevel, resultList);
        }
    }
}
