package com.rookie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        BinaryTreeInorderTraversal treeInorderTraversal = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        root.right = node;
        node.left = node1;
        System.out.println(treeInorderTraversal.inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(result, root);
        return result;
    }

    private void traversal(List<Integer> list, TreeNode node) {
        if (node != null) {
            traversal(list, node.left);
            list.add(node.val);
            traversal(list, node.right);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
