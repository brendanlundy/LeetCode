package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Problem001 {
    /* Two Sum
    
     Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
     */

    public static void main(String[] args) {
        //int[] answer = twoSum(new int[] { 2, 7, 11, 15 }, 13);
        //int[] answer = twoSum(new int[] { 3, 2, 4 }, 6);
        //int[] answer = twoSum(new int[] { 0, 4, 3, 0 }, 0);
        //System.out.println(answer[0]);
        //System.out.println(answer[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indeces = new int[2];

        //this is a map of the number and its position
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            int otherNum = target - entry.getKey();
            if (map.containsKey(otherNum)) {
                indeces[0] = entry.getValue();
                indeces[1] = map.get(otherNum);
                //if the 2 numbers are equal to each other then we have to find the other's position
                if (indeces[0] == indeces[1]) {
                    for (int i = 0; i < nums.length; i++) {
                        if (entry.getKey() == nums[i] && entry.getValue() != i) {
                            indeces[0] = i;
                            break;
                        }
                    }
                }
                break;
            }
        }

        //index is not 0 based so add 1 and then sort it
        indeces[0] += 1;
        indeces[1] += 1;
        if (indeces[0] > indeces[1]) {
            int temp = indeces[1];
            indeces[1] = indeces[0];
            indeces[0] = temp;
        }
        return indeces;
    }
}
