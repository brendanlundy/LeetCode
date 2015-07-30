package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Problem047 {
    public static void main(String[] args) {
        List<List<Integer>> answers = permuteUnique(new int[] { 1, 2, 3 });
        for (List<Integer> answer : answers) {
            for (int a : answer) {
                System.out.print(a);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answers = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return answers;
        else if (nums.length == 1) {
            List<Integer> t = new ArrayList<Integer>();
            t.add(nums[0]);
            answers.add(t);
            return answers;
        }

        List<Integer> answer = new ArrayList<Integer>();
        for (Integer num : nums) {
            answer.add(num);
        }
        Collections.sort(answer);
        answers.add(answer);
        List<Integer> next = new ArrayList<Integer>(answer);

        while (nextPermutation(next)) {
            answers.add(new ArrayList<Integer>(next));
        }

        return answers;
    }

    private static boolean nextPermutation(List<Integer> nums) {
        int start = nums.size() - 1;

        while (start > 0) {
            if (nums.get(start) > nums.get(start - 1)) {
                for (int i = nums.size() - 1; i >= start; i--) {
                    if (nums.get(i) > nums.get(start - 1)) {
                        int temp = nums.get(i);
                        nums.set(i, nums.get(start - 1));
                        nums.set(start - 1, temp);
                        break;
                    }
                }

                reverse(nums, start);
                return true;
            }
            start--;
        }

        //return false since we are at the biggest permutation
        return false;
    }

    private static void reverse(List<Integer> nums, int left) {
        int right = nums.size() - 1;
        while (left < right) {
            int temp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, temp);
            left++;
            right--;
        }
    }

    public static List<List<Integer>> permuteUniqueFirst(int[] nums) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Set<Integer> uniqueNums = new HashSet<Integer>();
        List<Integer> answer = new ArrayList<Integer>();
        for (int num : nums) {
            if (!uniqueNums.contains(num)) {
                uniqueNums.add(num);
                answer.add(num);
            }
        }
        permuteRecurse(set, answer, 0);

        List<List<Integer>> answers = new LinkedList<List<Integer>>();
        for (List<Integer> a : set) {
            answers.add(a);
        }
        return answers;
    }

    private static void permuteRecurse(Set<List<Integer>> set, List<Integer> answer, int start) {
        if (start == answer.size())
            set.add(new ArrayList<Integer>(answer));

        for (int i = start; i < answer.size(); i++) {
            int temp = answer.get(i);
            answer.set(i, answer.get(start));
            answer.set(start, temp);
            permuteRecurse(set, answer, start + 1);
            //swap back
            answer.set(start, answer.get(i));
            answer.set(i, temp);
        }
    }
}
