class Solution {
    public int romanToDecimal(String s) {
        // code here
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n-1;i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i+1);
            int val1 = find(ch1);
            int val2 = find(ch2);
            
            if(val1<val2) ans = ans-val1;
            else ans = ans+val1;
        }
        int val = find(s.charAt(n-1));
        return ans+val;
    }
    
    public int find(char ch){
        if(ch=='I') return 1;
        else if(ch=='V') return 5;
        else if(ch=='X') return 10;
        else if(ch=='L') return 50;
        else if(ch=='C') return 100;
        else if(ch=='D') return 500;
        else return 1000;
    }
}
