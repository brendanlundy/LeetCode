package algorithms;

public class Problem098 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(4);
        System.out.println(isValidBST(root));

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        if (isValidBSTRecurse(root, 0, 0, true, true))
            return true;

        return false;
    }

    private static boolean isValidBSTRecurse(TreeNode root, int min, int max, boolean noMin, boolean noMax) {
        if ((!noMax && root.val >= max) || (!noMin && root.val <= min))
            return false;

        if (root.left != null) {
            if (!isValidBSTRecurse(root.left, min, root.val, noMin, false))
                return false;
        }
        if (root.right != null) {
            if (!isValidBSTRecurse(root.right, root.val, max, false, noMax))
                return false;
        }

        return true;
    }
}
