package algorithms;

public class Problem014 {

    public static void main(String[] args) {
        //System.out.println(longestCommonPrefix(new String[] { "hello", "hey", "hear" }));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        int length = prefix.length();

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            length = Math.min(length, str.length());
            for (int j = 0; j < length; j++) {
                if (prefix.charAt(j) != str.charAt(j)) {
                    length = j;
                    break;
                }
            }
            if (length == 0)
                break;
        }
        return prefix.substring(0, length);
    }
}
