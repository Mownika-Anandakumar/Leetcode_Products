class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) {
            return false; 
        }
        int opening = 0, closing = 0;
        int wildCard = 0;
        for (int i = 0; i < n; ++i) {
            if (locked.charAt(i) == '0') {
                wildCard++;
            } else if (s.charAt(i) == '(') {
                opening++;
            } else {
                closing++;
            }
            if (wildCard < (closing - opening)) {
                return false;
            }
        }
        opening = closing = wildCard = 0;
        for (int i = n - 1; i >= 0; --i) { 
            if (locked.charAt(i) == '0') {
                wildCard++;
            } else if (s.charAt(i) == '(') {
                opening++;
            } else {
                closing++;
            }
            if (wildCard < (opening - closing)) {
                return false;
            }
        }
        return true;
    }
}
