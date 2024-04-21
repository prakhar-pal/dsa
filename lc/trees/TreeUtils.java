package lc.trees;

public class TreeUtils {
    public static TreeNode createTree(Integer[] nums) {
        if(nums.length == 0) {
            return null;
        }
        TreeNode[] treeArray = new TreeNode[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != null) {
                treeArray[i] = new TreeNode(nums[i]);
            }
        }

        for(int i=0;i<nums.length;i++) {
            if(2*i +1 < nums.length) {
                treeArray[i].left = treeArray[2*i+1];
            }
            if(2*i + 2 < nums.length) {
                treeArray[i].right = treeArray[2*i + 2];
            }
        }
        return treeArray[0];
    }
}
