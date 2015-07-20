package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import utility.Timer;

public class Problem040 {

    public static void main(String[] args) {
        Timer t = new Timer();
        t.start();

        List<List<Integer>> answers = combinationSum2(new int[] { 14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9,
                9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16,
                8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12 }, 27);

        //List<List<Integer>> answers = combinationSum2(new int[] { 14, 2, 25 }, 27);
        for (List<Integer> answer : answers) {
            System.out.println(answer);
        }

        t.end();
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answers = new LinkedList<List<Integer>>();
        int length = candidates.length;
        if (candidates == null || length == 0)
            return answers;

        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Stack<Integer> current = new Stack<Integer>();
        combinationSumRecurse(set, candidates, target, current, 0, 0);

        answers.addAll(set);
        return answers;
    }

    private static void combinationSumRecurse(Set<List<Integer>> set, int[] candidates, int target,
            Stack<Integer> current, int sum, int index) {
        if (sum == target) {
            ArrayList<Integer> temp = new ArrayList<Integer>(current);
            set.add(temp);
            return;
        } else if (sum > target)
            return;

        if (index == candidates.length)
            return;

        combinationSumRecurse(set, candidates, target, current, sum, index + 1);

        int num = candidates[index];
        current.add(num);
        combinationSumRecurse(set, candidates, target, current, sum + num, index + 1);
        current.pop();
    }
}
