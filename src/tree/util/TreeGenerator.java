package tree.util;

import java.util.ArrayList;
import java.util.List;

public class TreeGenerator {
    public static void main(String[] args) throws Exception {
        Integer[] data = new Integer[] { 1, 3, 5, null, null, 10, 12 };
        TreeNode root = build(data);
        System.out.println(root);
    }

    public static TreeNode build(Integer[] data) {
        List<TreeNode> nodeList = new ArrayList<>();

        for (Integer item : data) {
            if (item == null) {
                nodeList.add(null);
            } else {
                TreeNode node = new TreeNode();
                node.val = item;
                nodeList.add(node);
            }
        }
        for (int i = 0; i < data.length; i++) {
            TreeNode node = nodeList.get(i);
            if (node == null) {
                continue;
            }
            int leftIndex = 2 * i + 1;
            if (leftIndex >= data.length) {
                node.left = null;
            } else {
                node.left = nodeList.get(leftIndex);
            }

            int rightIndex = leftIndex + 1;
            if (rightIndex >= data.length) {
                node.right = null;
            } else {
                node.right = nodeList.get(rightIndex);
            }
        }
        return nodeList.get(0);
    }
}