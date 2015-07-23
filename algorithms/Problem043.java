package algorithms;

public class Problem043 {

    public static void main(String[] args) {
        System.out.println(multiply("999", "999"));

    }

    public static String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0)
            return "";
        int num1length = num1.length();
        int num2length = num2.length();
        int[] total = new int[num1length + num2length];
        int[] num1array = new int[num1length];

        for (int i = 0; i < num1length; i++) {
            int n1 = getInt(num1.charAt(i));
            if (n1 == -1)
                return "";
            num1array[i] = n1;
        }

        int totalIndex = total.length;
        for (int i = num2length - 1; i >= 0; i--) {
            int n2 = getInt(num2.charAt(i));
            if (n2 == -1)
                return "";

            totalIndex--;
            int index = totalIndex;
            int carry = 0;
            for (int j = num1length - 1; j >= 0; j--) {
                int n1 = num1array[j];
                int prod = (n1 * n2) + carry;
                carry = prod / 10;
                int digit = prod % 10;

                int sum = total[index] + digit;
                total[index] = sum % 10;
                if (index > 0) {
                    total[index - 1] += sum / 10;
                }

                index--;
            }

            if (index >= 0) {
                total[index] += carry;
            }
        }

        //remove all the leading 0s (but leave the last one if the number is "0"
        int nonzero = 0;
        while (nonzero < total.length - 1) {
            if (total[nonzero] == 0)
                nonzero++;
            else
                break;
        }
        StringBuilder sb = new StringBuilder();
        while (nonzero < total.length) {
            sb.append(total[nonzero]);
            nonzero++;
        }
        return sb.toString();
    }

    private static int getInt(char c) {
        switch (c) {
        case '0':
            return 0;
        case '1':
            return 1;
        case '2':
            return 2;
        case '3':
            return 3;
        case '4':
            return 4;
        case '5':
            return 5;
        case '6':
            return 6;
        case '7':
            return 7;
        case '8':
            return 8;
        case '9':
            return 9;
        default:
            return -1;
        }
    }

}
