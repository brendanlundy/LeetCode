package algorithms;

public class Problem048 {

    public static void main(String[] args) {
        //int[][] image = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int[][] image = new int[][] { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 } };
        rotate(image);
        for (int[] row : image) {
            for (int val : row) {
                System.out.print(val);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2 || matrix.length != matrix[0].length)
            return;
        else if (matrix.length == 2) {
            //swap. is this needed.
        }

        int size = matrix.length;
        int[][] copy = new int[size][size];
        int mid = size / 2;
        int[][] corners = new int[][] { { 0, 0 }, { 0, size - 1 }, { size - 1, size - 1 }, { size - 1, 0 } };

        for (int[] corner : corners) {
            int row = corner[0];
            int col = corner[1];

            if (row < mid && col < mid) {
                //top left corner
                int newColumn = size - 1 - col;
                int newRow = row;
                for (int i = col; i < newColumn; i++) {
                    copy[newRow][newColumn] = matrix[row][i];
                    newRow++;
                }
            } else if (row >= mid && col >= mid) {
                //bottom right corner
                int newColumn = size - 1 - col;
                int newRow = row;
                for (int i = col; i > newColumn; i--) {
                    copy[newRow][newColumn] = matrix[row][i];
                    newRow--;
                }
            } else if (col >= mid && row < mid) {
                //top right corner
                int newColumn = col;
                int newRow = size - 1 - row;
                for (int i = row; i < newRow; i++) {
                    copy[newRow][newColumn] = matrix[row][i];
                    newColumn--;
                }
            } else {
                //botom left corner
                int newColumn = col;
                int newRow = size - 1 - row;
                for (int i = row; i > newRow; i--) {
                    copy[newRow][newColumn] = matrix[row][i];
                    newColumn++;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = copy[i][j];
            }
        }
    }
}
