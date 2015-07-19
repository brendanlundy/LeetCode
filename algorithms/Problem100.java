package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class Problem100 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println(isSameTree(root, root2));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pq = new LinkedList<TreeNode>();
        Queue<TreeNode> qq = new LinkedList<TreeNode>();

        pq.add(p);
        qq.add(q);

        while (!pq.isEmpty()) {
            if (qq.isEmpty())
                return false;

            TreeNode pcurrent = pq.poll();
            TreeNode qcurrent = qq.poll();
            if (pcurrent != null && qcurrent != null) {
                if (pcurrent.val != qcurrent.val)
                    return false;
                pq.add(pcurrent.left);
                pq.add(pcurrent.right);
                qq.add(qcurrent.left);
                qq.add(qcurrent.right);
            } else if (!(pcurrent == null && qcurrent == null))
                return false;
        }

        return true;
    }
}
