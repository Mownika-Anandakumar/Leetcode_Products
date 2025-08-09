class Solution {
    int getLongestPrefix(String s) {
        // code here
      int n = s.length();

        // Start from largest proper prefix and go down
        for (int len = n - 1; len >= 1; len--) {
           boolean value = true;

           
            for(int i=len; i < n;i++)
            {
                if(s.charAt(i)!=s.charAt(i%len)){
                    value = false;
                    break;
                }
            }

             if(value)return len;
            }
       
        return -1; // no such prefix
    }

    //public static void main(String[] args) {
      //  System.out.println(longestPeriodicProperPrefix("aaaaaa")); // 5
        //System.out.println(longestPeriodicProperPrefix("abcab"));  // 3
        //System.out.println(longestPeriodicProperPrefix("ababd"));  // -1
    //}
}
