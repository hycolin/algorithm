package tree;

import tree.util.TreeGenerator;
import tree.util.TreeNode;

// 查找两个节点的最近公共祖先
public class LowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] data = new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };

        TreeNode root = TreeGenerator.build(data);
        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(4);
        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root, p, q));
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.equals(p)) {
            return p;
        }

        if (root.equals(q)) {
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
