package tree.traversal;

import java.util.ArrayList;
import java.util.List;

import tree.util.TreeGenerator;
import tree.util.TreeNode;

public class NormalOrder {
    public static void main(String[] args) {
        Integer[] data = new Integer[] { 1, 2, 3, 21, 22, 23, 24 };
        TreeNode root = TreeGenerator.build(data);
        System.out.println(root);

        {
            List<Integer> result = new ArrayList<>();
            new NormalOrder().preorder(root, result);
            System.out.println(result);
        }

        {
            List<Integer> result = new ArrayList<>();
            new NormalOrder().inorder(root, result);
            System.out.println(result);
        }

        {
            List<Integer> result = new ArrayList<>();
            new NormalOrder().postorder(root, result);
            System.out.println(result);
        }

    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

}
