class Solution {
    public int reverse(int x) {
        int remainder=0;
        int temp=0;
        while(x!=0){
        remainder=x%10;
        if(temp<Integer.MIN_VALUE/10 || temp>Integer.MAX_VALUE/10){
          return 0;
        }
        temp=temp*10+remainder;
        x=x/10;
        }
        return temp;
    }
}
