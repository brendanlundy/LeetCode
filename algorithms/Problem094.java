package algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem094 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> answer = inorderTraversal(root);
        for (int a : answer)
            System.out.print(a);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<Integer>();

        inorderTraversalRecurse(answer, root);

        return answer;
    }

    private static void inorderTraversalRecurse(List<Integer> answer, TreeNode root) {
        if (root == null)
            return;

        inorderTraversalRecurse(answer, root.left);
        answer.add(root.val);
        inorderTraversalRecurse(answer, root.right);
    }

    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> answer = new LinkedList<Integer>();
        if (root == null)
            return answer;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        boolean finished = false;
        TreeNode current = root;
        while (!finished) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.isEmpty())
                    finished = true;
                else {
                    current = stack.pop();
                    answer.add(current.val);
                    current = current.right;
                }
            }
        }

        return answer;
    }
}
