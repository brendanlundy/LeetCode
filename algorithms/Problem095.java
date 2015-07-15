package algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem095 {

    public static void main(String[] args) {
        List<TreeNode> answers = generateTrees(2);
        for (TreeNode root : answers) {
            printLevelTraversal(root);
            System.out.println();
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        return generateTreesRecurse(1, n);
    }

    private static List<TreeNode> generateTreesRecurse(int start, int end) {
        List<TreeNode> answers = new LinkedList<TreeNode>();

        if (start > end) {
            answers.add(null);
            return answers;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTreesRecurse(start, i - 1);
            List<TreeNode> rights = generateTreesRecurse(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    answers.add(node);
                }
            }
        }

        return answers;
    }

    private static void printLevelTraversal(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);
        int numThisLevel = 1;
        while (numThisLevel > 0) {

            while (numThisLevel > 0) {
                numThisLevel--;
                TreeNode current = q.poll();
                if (current != null) {
                    System.out.print(current.val);
                    System.out.print(" ");
                    q.add(current.left);
                    q.add(current.right);
                }
            }

            System.out.println();
            numThisLevel = q.size();
        }
    }
}
