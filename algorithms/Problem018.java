package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Problem018 {

    public static void main(String[] args) {
        //int[] test = new int[] { 1, 0, -1, 0, -2, 2 };
        int[] test = new int[] { 1, -2, -5, -4, -3, 3, 3, 5 };
        long startTime = System.nanoTime();
        List<List<Integer>> answers = fourSum(test, -11);
        System.out.print((System.nanoTime() - startTime) * 0.000000001);
        System.out.println(" Seconds");

        for (List<Integer> answer : answers) {
            for (Integer inta : answer) {
                System.out.print(inta);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answers = new LinkedList<List<Integer>>();
        if (nums.length < 4)
            return answers;

        Set<List<Integer>> answerSet = new HashSet<List<Integer>>();
        Arrays.sort(nums);

        int length = nums.length;

        for (int i = 0; i < (length - 3); i++) {
            int a = nums[i];
            for (int j = i + 1; j < (length - 2); j++) {
                int d = nums[j];
                int start = j + 1;
                int end = length - 1;

                while (start < end) {
                    int b = nums[start];
                    int c = nums[end];
                    int sum = a + b + c + d;
                    if (sum == target) {
                        answerSet.add(Arrays.asList(new Integer[] { a, d, b, c }));
                        start++;
                        end--;
                    } else if (sum > target) {
                        end--;
                    } else
                        start++;
                }
            }
        }

        answers.addAll(answerSet);
        return answers;
    }
}
