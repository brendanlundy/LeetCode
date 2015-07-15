package algorithms;

public class Problem096 {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        if (n < 1)
            return 0;
        else if (n == 1)
            return 1;

        int[] numTreesWithXNodes = new int[n + 1];
        numTreesWithXNodes[0] = 1;
        numTreesWithXNodes[1] = 1;

        //each number could be the root
        for (int i = 2; i <= n; i++) {
            //left subtree could have 0 up through i-1 nodes
            for (int j = 0; j < i; j++) {
                //multiply to account for unique combo of left and right subtree
                numTreesWithXNodes[i] += numTreesWithXNodes[j] * numTreesWithXNodes[i - j - 1];
            }
        }

        return numTreesWithXNodes[n];
    }
}
