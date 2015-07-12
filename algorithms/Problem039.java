package algorithms;

import java.util.LinkedList;
import java.util.List;

public class Problem039 {

    public static void main(String[] args) {
        List<List<Integer>> answers = combinationSum(new int[] { 2, 3, 3, 7 }, 7);
        for (List<Integer> answer : answers) {
            System.out.println(answer);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answers = new LinkedList<List<Integer>>();

        List<Integer> a = new LinkedList<Integer>();

        return answers;
    }
}
