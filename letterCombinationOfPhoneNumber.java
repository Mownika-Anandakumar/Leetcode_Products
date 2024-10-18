class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] mapping = {
            "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        }; 
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), digits, 0, mapping);
        return result;
    }
    private void backtrack(List<String> result, StringBuilder combination, String digits, int index, String[] mapping) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            backtrack(result, combination, digits, index + 1, mapping);
            combination.deleteCharAt(combination.length() - 1); 
        }
    }
}
