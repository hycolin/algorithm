package tree.util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public String toString() {
        return "" + val;
    }

    public boolean equals(TreeNode other) {
        if (other == null) {
            return false;
        }
        return this.val == other.val;
    }
}