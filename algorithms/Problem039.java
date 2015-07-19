package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem039 {

    public static void main(String[] args) {
        List<List<Integer>> answers = combinationSum(new int[] { 2, 6, 3, 7 }, 7);
        for (List<Integer> answer : answers) {
            System.out.println(answer);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answers = new LinkedList<List<Integer>>();
        if (candidates == null || candidates.length == 0)
            return answers;

        Arrays.sort(candidates);
        Stack<Integer> current = new Stack<Integer>();
        combinationSumRecurse(answers, candidates, target, current, 0, 0);

        return answers;
    }

    private static void combinationSumRecurse(List<List<Integer>> answers, int[] candidates, int target,
            Stack<Integer> current, int sum, int index) {
        if (sum == target) {
            ArrayList<Integer> temp = new ArrayList<Integer>(current);
            answers.add(temp);
            return;
        } else if (sum > target)
            return;

        if (index == candidates.length)
            return;

        int num = candidates[index];
        boolean first = true;
        int count = 0;
        while (sum <= target) {
            if (first) {
                first = false;
            } else {
                count++;
                current.add(num);
            }
            combinationSumRecurse(answers, candidates, target, current, sum, index + 1);

            sum += num;
        }

        while (count > 0) {
            count--;
            current.pop();
        }
    }
}
