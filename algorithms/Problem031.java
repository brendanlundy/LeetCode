package algorithms;

public class Problem031 {

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 3, 2 };
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int start = nums.length - 1;

        while (start > 0) {
            if (nums[start] > nums[start - 1]) {
                for (int i = nums.length - 1; i >= start; i--) {
                    if (nums[i] > nums[start - 1]) {
                        int temp = nums[i];
                        nums[i] = nums[start - 1];
                        nums[start - 1] = temp;
                        break;
                    }
                }
                reverse(nums, start);

                return;
            }
            start--;
        }

        //the array is in descending order
        reverse(nums, 0);
    }

    private static void reverse(int[] nums, int left) {
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
