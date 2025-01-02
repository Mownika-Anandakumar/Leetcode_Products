import java.util.*;
class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n + 1];
        // Pre-compute prefix sum for count of strings starting and ending with vowel
        for (int i = 0; i < n; ++i) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            if (isVowel(start) && isVowel(end)) {
                prefixSum[i + 1] = 1 + prefixSum[i];
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }
        // Compute each query
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = prefixSum[end + 1] - prefixSum[start];
        }
        return result;
    }
}
