package algorithms;

public class Problem027 {

    public static void main(String[] args) {
        int[] test = new int[] { 1, 4, 2, 3, 2 };
        int answer = removeElement(test, 2);
        System.out.println(answer);
        System.out.println();
        for (int i = 0; i < answer; i++) {
            System.out.println(test[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 0)
            return 0;

        int end = length - 1;
        int numValid = 0;
        int start = 0;
        while (start <= end) {
            int num = nums[start];
            if (num == val) {
                nums[start] = nums[end];
                end--;
            } else {
                numValid++;
                start++;
            }
        }
        return numValid;
    }
}
