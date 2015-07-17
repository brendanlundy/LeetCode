package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class Problem099 {

    public static void main(String[] args) {
        /*
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(8);
        */
        /*
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        recoverTree(root);
        printLevelTraversal(root);
        System.out.println();

        root = new TreeNode(0);
        root.left = new TreeNode(1);
        recoverTree(root);
        printLevelTraversal(root);

        root = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(1);
        recoverTree(root);
        printLevelTraversal(root);

        root = new TreeNode(3);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        recoverTree(root);
        printLevelTraversal(root);
        */
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode node1 = null;
    TreeNode node2 = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null)
            return;
        inorderTraverse(root.left);
        if (prev != null) {
            if (root.val <= prev.val) {
                if (node1 == null)
                    node1 = prev;
                node2 = root;
            }
        }
        prev = root;
        inorderTraverse(root.right);
    }

    /*
    public static void recoverTreeMine(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        TreeNode node1 = null;
        TreeNode node2 = null;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current.left != null) {
                if (current.left.val > current.val) {
                    if (node1 == null) {
                        node1 = current;
                        node2 = current.left;
                    } else {
                        int a = Math.abs(node1.val - current.left.val);
                        int b = Math.abs(node2.val - current.left.val);
                        int c = Math.abs(node1.val - node2.val);
                        if (a > b && a > c)
                            node2 = current.left;
                        else if (b > c)
                            node1 = current.left;
                        break;
                    }
                }
                q.add(current.left);
            }
            if (current.right != null) {
                if (current.right.val < current.val) {
                    if (node1 == null) {
                        node1 = current;
                        node2 = current.right;
                    } else {
                        int a = Math.abs(node1.val - current.right.val);
                        int b = Math.abs(node2.val - current.right.val);
                        int c = Math.abs(node1.val - node2.val);
                        if (a > b && a > c)
                            node2 = current.right;
                        else if (b > c)
                            node1 = current.right;
                        break;
                    }

                }
                q.add(current.right);
            }
        }

        if (node1 != null && node2 != null) {
            int tempVal = node1.val;
            node1.val = node2.val;
            node2.val = tempVal;
        }
    }
    */

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
