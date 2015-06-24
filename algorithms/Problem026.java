package algorithms;

public class Problem026 {

    public static void main(String[] args) {
        int[] test = new int[] { 1, 2, 2, 3 };
        int answer = removeDuplicates(test);
        System.out.println(answer);
        System.out.println();
        for (int i = 0; i < answer; i++) {
            System.out.println(test[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;

        int prev = nums[0];
        int nextAvailableIndex = 1;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num != prev) {
                nums[nextAvailableIndex] = num;
                nextAvailableIndex++;
                prev = num;
            }
        }
        return nextAvailableIndex;
    }

}
