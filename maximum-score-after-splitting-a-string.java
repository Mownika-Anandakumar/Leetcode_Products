class Solution {
    public int maxScore(String s) {
      int n=s.length();
      int one_cnt=0;
      for(int i=0;i<n;i++){
        if(s.charAt(i)=='1'){
            one_cnt++;
        }
      }  
      int zero_cnt=0;
      int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) { 
            if (s.charAt(i) == '0') {
                zero_cnt++;
            } else {
                one_cnt--;
            }
            int currentScore = zero_cnt + one_cnt;
            maxScore = Math.max(maxScore, currentScore);
        }
        return maxScore;
    }
}
