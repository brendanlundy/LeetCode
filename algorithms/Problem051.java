package algorithms;

import java.util.LinkedList;
import java.util.List;

public class Problem051 {

    public static void main(String[] args) {

        List<String[]> answers = solveNQueens(5);
        for (String[] answer : answers) {
            for (String a : answer) {
                System.out.println(a);
            }
            System.out.println();
        }
        System.out.println(answers.size());

        enumerate(5);
    }

    public static List<String[]> solveNQueens(int n) {
        List<String[]> answers = new LinkedList<String[]>();
        if (n < 1)
            return answers;
        else if (n == 1) {
            answers.add(new String[] { "Q" });
            return answers;
        }

        /*
        char[][] layout = new char[n][n];
        for (int i = 0; i < n / 2; i++) {
            resetLayout(layout, n);
            addQueen(layout, 0, i, n);
            recurseSolveNQueens(answers, layout, 1, n);
        }
        if (n % 2 == 1) {
            resetLayout(layout, n);
            addQueen(layout, 0, n / 2, n);
            recurseSolveNQueens(answers, layout, 1, n);
        }
        */
        char[][] layout = new char[n][n];
        resetLayout(layout, n);
        recurseSolveNQueens(answers, layout, 0, n);

        return answers;
    }

    private static void recurseSolveNQueens(List<String[]> answers, char[][] layout, int currentRow, int n) {
        if (currentRow == n) {
            //finished adding queens
            addAnswer(answers, layout);
        } else {
            //still have more queens to add
            for (int col = 0; col < n; col++) {
                if (layout[currentRow][col] == '.') {
                    char[][] copyLayout = new char[n][n];
                    copyLayout(layout, copyLayout, n);
                    addQueen(layout, currentRow, col, n);
                    recurseSolveNQueens(answers, layout, currentRow + 1, n);
                    copyLayout(copyLayout, layout, n);
                }
            }
        }
    }

    private static void copyLayout(char[][] copiedFrom, char[][] copiedInto, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copiedInto[i][j] = copiedFrom[i][j];
            }
        }
    }

    private static void addAnswer(List<String[]> answers, char[][] layout) {
        int n = layout.length;
        char[][] charanswer = new char[n][n];
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (layout[i][j] == 'x')
                    charanswer[i][j] = '.';
                else
                    charanswer[i][j] = layout[i][j];
            }
            answer[i] = new String(charanswer[i]);
        }
        answers.add(answer);

        //also add the mirrored answer
        /*
        int col = -1;
        for (int i = 0; i < n; i++) {
            if (charanswer[0][i] == 'Q') {
                col = i;
                break;
            }
        }
        if (n % 2 == 0 || col != n / 2) {
            String[] mirrorAnswer = new String[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (charanswer[i][j] == 'Q') {
                        charanswer[i][j] = '.';
                        charanswer[i][n - 1 - j] = 'Q';
                        break;
                    }
                }
                mirrorAnswer[i] = new String(charanswer[i]);
            }
            answers.add(mirrorAnswer);
        }
        */
    }

    private static void resetLayout(char[][] layout, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                layout[i][j] = '.';
            }
        }
    }

    private static void addQueen(char[][] layout, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            layout[row][i] = 'x';
        }
        for (int i = 0; i < n; i++) {
            layout[i][col] = 'x';
        }
        int r = row;
        int c = col;
        while (r > 0 && c > 0) {
            r--;
            c--;
            layout[r][c] = 'x';
        }
        r = row;
        c = col;
        while (r < (n - 1) && c < (n - 1)) {
            r++;
            c++;
            layout[r][c] = 'x';
        }
        r = row;
        c = col;
        while (r > 0 && c < (n - 1)) {
            r--;
            c++;
            layout[r][c] = 'x';
        }
        r = row;
        c = col;
        while (r < (n - 1) && c > 0) {
            r++;
            c--;
            layout[r][c] = 'x';
        }

        layout[row][col] = 'Q';
    }

    private static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])
                return false; // same column
            if ((q[i] - q[n]) == (n - i))
                return false; // same major diagonal
            if ((q[n] - q[i]) == (n - i))
                return false; // same minor diagonal
        }
        return true;
    }

    private static void printQueens(int[] q) {
        int N = q.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (q[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void enumerate(int N) {
        int[] a = new int[N];
        enumerate(a, 0);
    }

    private static void enumerate(int[] q, int n) {
        int N = q.length;
        if (n == N)
            printQueens(q);
        else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isConsistent(q, n))
                    enumerate(q, n + 1);
            }
        }
    }

}
