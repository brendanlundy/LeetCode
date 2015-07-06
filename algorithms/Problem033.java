package algorithms;

import java.util.Arrays;

public class Problem033 {

    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        int numslength = nums.length;
        if (numslength == 0)
            return -1;

        //find the pivot
        int pivot = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                pivot = i;
        }
        if (pivot == 0) {
            int index = Arrays.binarySearch(nums, target);
            if (index >= 0)
                return index;
            else
                return -1;
        }

        int lowIndex = pivot;
        int highIndex = lowIndex - 1;
        if (target > nums[highIndex] || target < nums[lowIndex])
            return -1;

        //do a binary search
        while (nums[lowIndex] < nums[highIndex]) {
            int mid = calculateMid(lowIndex, highIndex, numslength);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                lowIndex = mid + 1;
                if (lowIndex == numslength)
                    lowIndex = 0;
            } else {
                highIndex = mid - 1;
                if (highIndex == -1)
                    highIndex = numslength - 1;
            }
        }

        //check the end positions
        if (target == nums[highIndex])
            return highIndex;
        else if (target == nums[lowIndex])
            return lowIndex;

        return -1;
    }

    private static int calculateMid(int low, int high, int length) {
        if (low < high)
            return (low + high) / 2;

        int leftToZero = high;
        int rightToEnd = length - low - 1;
        int stepsToTake = (leftToZero + rightToEnd + 2) / 2;
        if (leftToZero < rightToEnd) {
            stepsToTake = stepsToTake - leftToZero - 1;
            return length - 1 - stepsToTake;
        } else {
            stepsToTake = stepsToTake - rightToEnd - 1;
            return stepsToTake;
        }
    }
}
