package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.util.TreeGenerator;
import tree.util.TreeNode;

public class NormalByIterator {
    public static void main(String[] args) {
        Integer[] data = new Integer[] { 1, 2, 3, 21, 22, 23, 24 };
        TreeNode root = TreeGenerator.build(data);
        System.out.println(preorder(root));
        System.out.println(inorder(root));
        System.out.println(postorder(root));
    }

    static List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);

            current = current.right;
        }
        return result;
    }

    static List<Integer> postorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }
        return result;
    }
}
