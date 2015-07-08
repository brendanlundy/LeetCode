package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Problem036 {
    public static void main(String[] args) {
        char[][] puzzle = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                System.out.print(puzzle[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println(isValidSudoku(puzzle));
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9)
            return false;

        Map<String, Boolean> sections = new HashMap<String, Boolean>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    String row = Integer.toString(i) + '-' + num;
                    if (sections.containsKey(row))
                        return false;
                    sections.put(row, true);

                    String col = Integer.toString(j + 9) + '-' + num;
                    if (sections.containsKey(col))
                        return false;
                    sections.put(col, true);

                    String square;
                    if (i < 3 && j < 3)
                        square = "18-";
                    else if (i < 3 && j < 6)
                        square = "19-";
                    else if (i < 3)
                        square = "20-";
                    else if (i < 6 && j < 3)
                        square = "21-";
                    else if (i < 6 && j < 6)
                        square = "22-";
                    else if (i < 6)
                        square = "23-";
                    else if (j < 3)
                        square = "24-";
                    else if (j < 6)
                        square = "25-";
                    else
                        square = "26-";
                    square += num;
                    if (sections.containsKey(square))
                        return false;
                    sections.put(square, true);
                }
            }
        }
        return true;
    }
}
