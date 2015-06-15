package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Problem006 {
    public static void main(String[] args) {
        //System.out.print(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        List<List<Character>> rows = new ArrayList<List<Character>>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<Character>());
        }

        int i = 0;
        int currentRow = 0;
        boolean inc = true;
        int length = s.length();
        while (i < length) {
            rows.get(currentRow).add(s.charAt(i));

            if (numRows > 1) {
                if (currentRow == numRows - 1)
                    inc = false;
                else if (currentRow == 0)
                    inc = true;
                if (inc)
                    currentRow++;
                else
                    currentRow--;
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            List<Character> row = rows.get(j);
            for (char c : row) {
                sb.append(c);
            }
        }
        return sb.toString();

    }
}
