package tree.util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public String toString() {
        return "" + val + "-" + left + "-" + right;
    }
}