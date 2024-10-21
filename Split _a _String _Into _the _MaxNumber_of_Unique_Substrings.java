import java.util.HashSet;
 class Solution{
    public int maxUniqueSplit(String s) {
              return backtrack(s, 0, new HashSet<>());
    }
        private int backtrack(String s, int start, HashSet<String> seenSubstrings) {
             if (start == s.length()) {
            return seenSubstrings.size();
        }
        int maxUnique = 0;
            for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);  
                       if (!seenSubstrings.contains(substring)) {
                seenSubstrings.add(substring);                 
              maxUnique = Math.max(maxUnique, backtrack(s, end, seenSubstrings));
  
                seenSubstrings.remove(substring);
            }
        } 
        return maxUnique;
    }
 }

    
