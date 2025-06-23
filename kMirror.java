class Solution {
    public long kMirror(int k, int n) {
        long ans = 0;
        List<Character> A = new ArrayList<>();
        A.add('0');

        for (int count = 0; count < n; count++) {
            while (true) {
                A = nextKMirror(A, k);
                StringBuilder baseKString = new StringBuilder();
                for (char c : A) {
                    baseKString.append(c);
                }
                long num = Long.parseLong(baseKString.toString(), k);
                if (isPalindrome(Long.toString(num))) {
                    ans += num;
                    break;
                }
            }
        }

        return ans;
    }

    private List<Character> nextKMirror(List<Character> A, int k) {
        int len = A.size();
        for (int i = len / 2; i < len; i++) {
            int nextNum = A.get(i) - '0' + 1;
            if (nextNum < k) {
                char ch = (char) ('0' + nextNum);
                A.set(i, ch);
                A.set(len - 1 - i, ch);
                for (int j = len / 2; j < i; j++) {
                    A.set(j, '0');
                    A.set(len - 1 - j, '0');
                }
                return A;
            }
        }

        List<Character> newA = new ArrayList<>();
        newA.add('1');
        for (int i = 0; i < len - 1; i++) {
            newA.add('0');
        }
        newA.add('1');
        return newA;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
