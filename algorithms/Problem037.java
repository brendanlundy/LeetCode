package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Problem037 {
    public static void main(String[] args) {
        char[][] puzzle = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        solveSudoku(puzzle);

        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                System.out.print(puzzle[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9)
            return;

        //check initial board configuration
        int numBlanks = 0;
        Map<String, Boolean> sections = new HashMap<String, Boolean>();
        int nextRow = -1;
        int nextCol = -1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    numBlanks++;
                    if (nextRow == -1) {
                        nextRow = i;
                        nextCol = j;
                    }
                } else {
                    for (String section : getSectionStrings(i, j, num)) {
                        if (sections.containsKey(section))
                            return;
                        else
                            sections.put(section, true);
                    }
                }
            }
        }
        if (numBlanks == 0)
            return;

        recurseSolveSudoku(board, numBlanks, sections, nextRow, nextCol);

    }

    private static boolean recurseSolveSudoku(char[][] board, int numBlanks, Map<String, Boolean> sections, int row,
            int col) {
        //if there are no blanks spaces then we have solved the puzzle
        if (numBlanks == 0)
            return true;

        //find where the next empty position would be
        int nextRow = -1;
        int nextCol = -1;
        boolean alreadyFoundCurrent = false;
        for (int i = row; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    if (alreadyFoundCurrent) {
                        nextRow = i;
                        nextCol = j;
                        break;
                    } else
                        alreadyFoundCurrent = true;
                }
            }
            if (nextRow > -1)
                break;
        }

        //try out all 9 numbers in this position
        String[] sectionStrings = getSectionStrings(row, col, 'X');
        for (char num : new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' }) {
            String rowSection = sectionStrings[0] + num;
            String colSection = sectionStrings[1] + num;
            String squareSection = sectionStrings[2] + num;

            if (!sections.containsKey(rowSection) && !sections.containsKey(colSection)
                    && !sections.containsKey(squareSection)) {
                sections.put(rowSection, true);
                sections.put(colSection, true);
                sections.put(squareSection, true);
                board[row][col] = num;

                if (recurseSolveSudoku(board, numBlanks - 1, sections, nextRow, nextCol))
                    return true;

                board[row][col] = '.';
                sections.remove(rowSection);
                sections.remove(colSection);
                sections.remove(squareSection);
            }
        }

        return false;
    }

    private static String[] getSectionStrings(int i, int j, char num) {
        String row;
        String col;
        if (num == 'X') {
            row = Integer.toString(i) + '-';
            col = Integer.toString(j + 9) + '-';
        } else {
            row = Integer.toString(i) + '-' + num;
            col = Integer.toString(j + 9) + '-' + num;
        }

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

        if (num != 'X')
            square += num;

        return new String[] { row, col, square };
    }
}
