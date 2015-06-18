package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Problem015 {

    public static void main(String[] args) {
        int[] test = new int[] { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14,
                4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15,
                10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1,
                -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2,
                -5, -11, 1, 3, -6 };
        long startTime = System.nanoTime();
        List<List<Integer>> answers = threeSum(test);
        //List<List<Integer>> answers = threeSumFirstAttempt(test);
        System.out.println((System.nanoTime() - startTime) * 0.000000001);
        /*
        for (List<Integer> answer : answers) {
            for (Integer inta : answer) {
                System.out.print(inta);
                System.out.print("\t");
            }
            System.out.println();
        }
        */
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new LinkedList<List<Integer>>();
        if (nums.length < 3)
            return answers;

        Set<List<Integer>> answerSet = new HashSet<List<Integer>>();
        Arrays.sort(nums);

        int length = nums.length;
        if (nums[0] > 0 || nums[length - 1] < 0)
            return answers;

        for (int i = 0; i < (length - 2); i++) {
            int a = nums[i];
            int start = i + 1;
            int end = length - 1;
            if (a > 0)
                break;
            while (start < end) {
                int b = nums[start];
                int c = nums[end];
                int sum = a + b + c;
                if (sum == 0) {
                    answerSet.add(Arrays.asList(new Integer[] { a, b, c }));
                    start++;
                    end--;
                } else if (sum > 0) {
                    end--;
                } else
                    start++;
            }
        }

        answers.addAll(answerSet);
        return answers;
    }

    public static List<List<Integer>> threeSumFirstAttempt(int[] nums) {
        List<List<Integer>> answers = new LinkedList<List<Integer>>();
        if (nums.length < 3)
            return answers;

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (hash.containsKey(num)) {
                hash.put(num, hash.get(num));
            } else
                hash.put(num, 1);
        }
        Set<List<Integer>> answerSet = new HashSet<List<Integer>>();

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    int a = nums[i];
                    int b = nums[j];
                    int c = -(a + b);
                    if (hash.containsKey(c)) {
                        if (a != b && a != c && b != c) {
                            Integer[] x = new Integer[] { a, b, c };
                            Arrays.sort(x);
                            answerSet.add(Arrays.asList(x));
                        } else if (a == b && a == c) {
                            if (hash.get(a) > 2)
                                answerSet.add(Arrays.asList(a, a, a));
                        } else if (a == b) {
                            if (hash.get(a) > 1) {
                                Integer[] x = new Integer[] { a, b, c };
                                Arrays.sort(x);
                                answerSet.add(Arrays.asList(x));
                            }
                        } else if (a == c) {
                            if (hash.get(a) > 1) {
                                Integer[] x = new Integer[] { a, b, c };
                                Arrays.sort(x);
                                answerSet.add(Arrays.asList(x));
                            }
                        } else if (b == c) {
                            if (hash.get(b) > 1) {
                                Integer[] x = new Integer[] { a, b, c };
                                Arrays.sort(x);
                                answerSet.add(Arrays.asList(x));
                            }
                        }
                    }
                }
            }
        }

        answers.addAll(answerSet);
        return answers;
    }
}
