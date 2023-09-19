package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import tree.util.TreeGenerator;
import tree.util.TreeNode;

public class LevelOrder {
    public List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Integer[] data = new Integer[] { 1, 21, 22, 31, 10, 0, null, 17, 19, 11, 13, 14, 15 };

        TreeNode root = TreeGenerator.build(data);
        LevelOrder levelOrder = new LevelOrder();

        levelOrder.bfs(root);
        System.out.println(levelOrder.result);

        levelOrder.result = new ArrayList<>();
        levelOrder.dfs(root, 0);
        System.out.println(levelOrder.result);
    }

    // 广度
    private void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int num = 0;
        while (!queue.isEmpty()) {
            num = queue.size();
            List<Integer> items = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.removeFirst();
                items.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            result.add(items);
        }
    }

    // 深度
    private void dfs(TreeNode node, int level) {
        if (node == null)
            return;

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        List<Integer> list = result.get(level);
        list.add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
