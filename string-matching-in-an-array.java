import java.util.*;
class Solution {
    void precomputeLPS(List<String> words, List<int[]> lps) {
        for (String word : words) {
            int m = word.length();
            int[] wordLPS = new int[m];
            // Two-pointer approach
            int i = 1, j = 0;
            while (i < m) {
                if (word.charAt(i) == word.charAt(j)) {
                    wordLPS[i] = j + 1;
                    i++;
                    j++;
                } else if (j > 0) {
                    j = wordLPS[j - 1];
                } else {
                    i++;
                }
            }
            lps.add(wordLPS);
        }
    }
    boolean stringMatcher(String pattern, int[] patternLPS, String text) {
        int patternSize = pattern.length();
        int textSize = text.length();
        int i = 0; // pattern pointer
        int j = 0; // text pointer
        while (i < patternSize && j < textSize) {
            if (pattern.charAt(i) == text.charAt(j)) {
                i++;
                j++;
            }
            if (i == patternSize)
                return true;
            if (j < textSize && pattern.charAt(i) != text.charAt(j)) {
                if (i > 0) {
                    i = patternLPS[i - 1];
                } else {
                    j++;
                }
            }
        }
        return false;
    }
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        // STEP-1: Sort by word size
        Arrays.sort(words, Comparator.comparingInt(String::length));
        // STEP-2: Precompute LPS for all words
        List<int[]> lps = new ArrayList<>();
        precomputeLPS(Arrays.asList(words), lps);
        // STEP-3: Match all O(N^2) combinations of words
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (stringMatcher(words[i], lps.get(i), words[j])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
