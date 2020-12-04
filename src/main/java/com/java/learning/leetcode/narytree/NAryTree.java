package com.java.learning.leetcode.narytree;


import com.java.learning.leetcode.binarytreepreordertraversal.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTree {
    //https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList();
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.children == null) {
            return;
        }
        for (Node child : node.children) {
            preOrder(child, list);
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList();
        postorder(root, list);
        return list;
    }

    private void postorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.children == null) {
            return;
        }
        for (Node child : node.children) {
            postorder(child, list);
        }
        list.add(node.val);
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node treeNode = queue.poll();
                level.add(treeNode.val);
                if (treeNode.children != null) {
                    for (Node node : treeNode.children) {
                        queue.offer(node);
                    }
                }
            }
            list.add(level);

        }
        return list;
    }
}
