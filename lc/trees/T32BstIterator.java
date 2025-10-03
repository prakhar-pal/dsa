package lc.trees;

import java.util.ArrayList;
import java.util.List;

class T32BstIterator {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createTree(new Integer[] {7, 3, 15, null, null, 9, 20});
        BSTIterator it = new BSTIterator(node);
        assert it.next() == 3;
        assert it.next() == 7;
        assert it.hasNext() == true;
        assert it.next() == 9;
        assert it.hasNext() == true;
        assert it.next() == 15;
        assert it.hasNext() == true;
        assert it.next() == 20;
        assert it.hasNext() == false;
    }
}

class BSTIterator {
    List<Integer> list;
    int pointer;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        pointer = 0;
        inorder(root, list);
    }
    
    public int next() {
        int nextValue = list.get(pointer);
        pointer++;
        return nextValue;
    }
    
    public boolean hasNext() {
        return pointer < list.size();
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}