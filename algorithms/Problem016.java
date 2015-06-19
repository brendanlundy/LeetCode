package algorithms;

import java.util.Arrays;

public class Problem016 {

    public static void main(String[] args) {
        int[] test = new int[] { -1, 2, 1, -4 };
        System.out.println(threeSumClosest(test, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return 0;

        Arrays.sort(nums);

        int length = nums.length;
        int best = 0;
        int bestdiff = Integer.MAX_VALUE;
        for (int i = 0; i < (length - 2); i++) {
            int a = nums[i];
            int start = i + 1;
            int end = length - 1;
            while (start < end) {
                int b = nums[start];
                int c = nums[end];
                int sum = a + b + c;
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    end--;
                } else
                    start++;

                int diff = Math.abs(sum - target);
                if (diff < bestdiff) {
                    bestdiff = diff;
                    best = sum;
                }
            }
        }

        return best;
    }
}
