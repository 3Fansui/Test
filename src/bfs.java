import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class bfs {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        dfs(root);
    }

    static List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null){
            return paths;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int c = 1;
        while (!queue.isEmpty()) {
            List<Integer> path = new ArrayList<>();
            int m = 0;
            for (int i = 0; i < c; i++) {
                TreeNode poll = queue.poll();
                path.add(poll.val);
                System.out.println(poll.val);
                if (poll.left != null) {
                    queue.offerLast(poll.left);
                    m++;
                }
                if (poll.right != null) {
                    queue.offerLast(poll.right);
                    m++;
                }
            }
            c = m;
            paths.add(path);
        }
        return paths;
    }

    static void dfs(TreeNode root){
        if (root == null) return;
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

