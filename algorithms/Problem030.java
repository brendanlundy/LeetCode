package algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem030 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<Integer> answer = findSubstring("barfoothefoobarman", new String[] { "foo", "bar" });
        long time = System.nanoTime() - startTime;
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
        System.out.println(time * 0.000000001);

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new LinkedList<Integer>();
        if (s.length() == 0 || words.length == 0)
            return answer;

        int wordLength = words[0].length();
        if (wordLength == 0)
            return answer;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        for (String word : words) {
            if (word.length() != wordLength)
                return answer;

            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        int i = 0;
        int slength = s.length();
        int concatWordsLength = wordLength * words.length;
        while (i <= (slength - concatWordsLength)) {
            Map<String, Integer> wordMapCopy = new HashMap<String, Integer>(wordMap);

            int index = substringHash(s, wordMapCopy, i, 0, words.length, wordLength);
            if (index >= 0)
                answer.add(index);

            i++;
        }
        return answer;

    }

    private static int substringHash(String s, Map<String, Integer> wordMap, int start, int numWordsMatched,
            int numTotalWords, int wordLength) {
        if (numWordsMatched == numTotalWords)
            return start - (wordLength * numTotalWords);

        String sub = s.substring(start, start + wordLength);
        if (wordMap.containsKey(sub)) {
            int numRemainingOfThisWord = wordMap.get(sub);
            if (numRemainingOfThisWord >= 1) {
                wordMap.put(sub, numRemainingOfThisWord - 1);
                return substringHash(s, wordMap, start + wordLength, numWordsMatched + 1, numTotalWords, wordLength);
            }
        }

        return -1;
    }

    public static List<Integer> findSubstringFirstAttempt(String s, String[] words) {
        List<Integer> answer = new LinkedList<Integer>();
        if (s.length() == 0 || words.length == 0)
            return answer;

        int wordLength = words[0].length();
        if (wordLength == 0)
            return answer;
        for (String word : words) {
            if (word.length() != wordLength)
                return answer;
        }
        boolean[] wordsUsed = new boolean[words.length];
        Arrays.sort(words);

        int i = 0;
        int slength = s.length();
        int concatWordsLength = wordLength * words.length;
        while (i <= (slength - concatWordsLength)) {
            for (int j = 0; j < wordsUsed.length; j++)
                wordsUsed[j] = false;

            int index = substring(s, words, wordsUsed, i, 0);
            if (index >= 0)
                answer.add(index);

            i++;
        }
        return answer;
    }

    private static int substring(String s, String[] words, boolean[] wordsUsed, int start, int numWordsMatched) {
        if (numWordsMatched == words.length)
            return start - (words[0].length() * words.length);

        int wordLength = words[0].length();
        String sub = s.substring(start, start + wordLength);
        int wordMatched = Arrays.binarySearch(words, sub);
        while (wordMatched > 0 && wordsUsed[wordMatched] == false) {
            if (sub.equals(words[wordMatched - 1])) {
                wordMatched--;
            } else
                break;
        }

        if (wordMatched >= 0) {
            while (wordMatched < words.length) {
                if (!sub.equals(words[wordMatched])) {
                    break;
                } else if (wordsUsed[wordMatched]) {
                    wordMatched++;
                } else {
                    wordsUsed[wordMatched] = true;
                    return substring(s, words, wordsUsed, start + wordLength, numWordsMatched + 1);
                }
            }
        }

        return -1;
    }
}
