package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem046 {

    public static void main(String[] args) {
        List<List<Integer>> answers = permute(new int[] { 1, 2, 3 });
        for (List<Integer> answer : answers) {
            for (int a : answer) {
                System.out.print(a);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new LinkedList<List<Integer>>();
        List<Integer> answer = new ArrayList<Integer>();
        for (int num : nums) {
            answer.add(num);
        }
        permuteRecurse(answers, answer, 0);
        return answers;
    }

    private static void permuteRecurse(List<List<Integer>> answers, List<Integer> answer, int start) {
        if (start == answer.size())
            answers.add(new ArrayList<Integer>(answer));

        for (int i = start; i < answer.size(); i++) {
            int temp = answer.get(i);
            answer.set(i, answer.get(start));
            answer.set(start, temp);
            permuteRecurse(answers, answer, start + 1);
            //swap back
            answer.set(start, answer.get(i));
            answer.set(i, temp);
        }
    }
}
