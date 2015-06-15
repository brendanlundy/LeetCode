package algorithms;

public class Problem074 {

    public static void main(String[] args) {
        //int[][] test = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        int[][] test = new int[][] { { 1 } };
        System.out.println(searchMatrix(test, 1));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0)
            return false;

        int rowlow = 0;
        int rowhigh = matrix.length - 1;
        int collow = 0;
        int colhigh = matrix[0].length - 1;

        //figure out which row it could be in
        while (rowlow < rowhigh) {
            int mid = (rowhigh + rowlow) / 2;
            int current = matrix[mid][colhigh];
            if (target > current) {
                rowlow = mid + 1;
            } else if (target < current) {
                rowhigh = mid;
            } else
                return true;
        }
        int row = rowlow;

        //figure out which col it could be in
        while (collow < colhigh) {
            int mid = (colhigh + collow) / 2;
            int current = matrix[row][mid];
            if (target > current) {
                collow = mid + 1;
            } else if (target < current) {
                colhigh = mid;
            } else
                return true;
        }

        if (matrix[row][collow] == target)
            return true;
        return false;
    }
}
