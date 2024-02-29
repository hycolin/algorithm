
package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.util.TreeGenerator;
import tree.util.TreeNode;

/**
 * 
 * input: [1, 2, 3, 21, 22, 23, 24]
 * 
 * output:
 * preorder: [1, 2, 21, 22, 3, 23, 24]
 * inorder: [21, 2, 22, 1, 23, 3, 24]
 * postorder: [21, 22, 2, 23, 24, 3, 1]
 */
public class GeneralTraversal {
    public static void main(String[] args) {
        Integer[] data = new Integer[] { 1, 2, 3, 21, 22, 23, 24 };
        TreeNode root = TreeGenerator.build(data);
        System.out.println(traversal(root));
    }

    static List<Integer> traversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int nodeLeft = 100;
        int nodeRight = 200;
        int nodeUp = 300;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int state = nodeLeft;

        while (node != null) {
            if (state == nodeLeft) {
                // result.add(node.val);
                if (node.left != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    state = nodeRight;
                }
            } else if (state == nodeRight) {
                // result.add(node.val);
                if (node.right != null) {
                    stack.push(node);
                    node = node.right;
                    state = nodeLeft;
                } else {
                    state = nodeUp;
                }
            } else {
                result.add(node.val);
                TreeNode parent = null;
                if (!stack.isEmpty()) {
                    parent = stack.pop();
                    if (parent.left == node) {
                        state = nodeRight;
                    }
                }
                node = parent;
            }
        }
        return result;
    }
}