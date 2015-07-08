package algorithms;

public class Problem035 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] { 5, 7, 8, 10 }, 1));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int mid = -1;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            int num = nums[mid];
            if (target > num) {
                left = mid + 1;
            } else if (target < num) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        if (target > nums[mid])
            return mid + 1;
        else
            return mid;
    }
}
