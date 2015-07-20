package algorithms;

public class Problem041 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] { 3, 4, 3, 1 }));
        System.out.println(firstMissingPositive(new int[] { 1, 2, 3, 4 }));

    }

    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int index = 0;
        //put each num into its correct position
        while (index < length) {
            int num = nums[index];
            if (num == (index + 1) || num <= 0 || num > length || nums[num - 1] == num)
                index++;
            else {
                nums[index] = nums[num - 1];
                nums[num - 1] = num;
            }
        }

        //search for first missing number
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num != i + 1)
                return i + 1;
        }

        return length + 1;
    }
}
