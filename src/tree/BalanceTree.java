package tree;

import tree.util.TreeGenerator;
import tree.util.TreeNode;

public class BalanceTree {
    public static void main(String[] args) {
        {
            Integer[] data = new Integer[] { 3, 9, 20, null, null, 15, 7 };
            TreeNode root = TreeGenerator.build(data);
            System.out.println(isBalanced(root));
        }

        {
            Integer[] data = new Integer[] { 1, 2, 2, 3, 3, null, null, 4, 4 };
            TreeNode root = TreeGenerator.build(data);
            System.out.println(isBalanced(root));
        }
    }

    static boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    static int recur(TreeNode node) {
        if (node == null)
            return 0;

        int left = recur(node.left);

        if (left == -1)
            return -1;

        int right = recur(node.right);

        if (right == -1)
            return -1;

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
