package algorithms;

public class Problem034 {
    public static void main(String[] args) {
        int[] answer = searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
        for (int a : answer)
            System.out.println(a);
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int numslength = nums.length;
        int right = numslength - 1;
        int hit = -1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int num = nums[mid];
            if (target > num) {
                left = mid + 1;
            } else if (target < num) {
                right = mid - 1;
            } else {
                hit = mid;
                break;
            }
        }

        //if not found through binary search
        if (hit == -1)
            return new int[] { -1, -1 };

        //we found the target and now must check how many duplicates there are in both directions
        left = hit - 1;
        while (left >= 0) {
            if (nums[left] != target)
                break;
            left--;
        }
        left++;
        right = hit + 1;
        while (right < nums.length) {
            if (nums[right] != target)
                break;
            right++;
        }
        right--;
        return new int[] { left, right };
    }
}
