package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tree.traversal.LevelOrder;
import tree.util.TreeNode;

public class BuildTree {
    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = new BuildTree().buildTree(preorder, inorder);
        List<List<Integer>> result = new ArrayList<>();
        new LevelOrder().dfs(root, 0, result);
        System.out.println(result);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            insertNode(root, node, map);
        }

        return root;
    }

    private void insertNode(TreeNode root, TreeNode node, Map<Integer, Integer> map) {
        while (root != node) {
            if (map.get(node.val) < map.get(root.val)) {
                if (root.left == null) {
                    root.left = node;
                }
                root = root.left;
            } else {
                if (root.right == null) {
                    root.right = node;
                }
                root = root.right;
            }
        }
    }
}
