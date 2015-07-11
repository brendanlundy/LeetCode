package algorithms;

public class Problem038 {

    public static void main(String[] args) {

    }

    public static String countAndSay(int n) {
        String answer = "1";
        for (int i = 1; i < n; i++) {
            int length = answer.length();
            StringBuilder sb = new StringBuilder();
            int j = 0;
            int count = 0;
            char currentChar = answer.charAt(0);
            while (j < length) {
                char nextChar = answer.charAt(j);
                if (nextChar == currentChar) {
                    count++;
                } else {
                    sb.append(Integer.toString(count));
                    sb.append(currentChar);
                    count = 1;
                    currentChar = nextChar;
                }
                j++;
            }
            sb.append(Integer.toString(count));
            sb.append(currentChar);
            answer = sb.toString();
        }
        return answer;
    }
}
