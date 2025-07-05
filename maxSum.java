class Solution {
    public int maxSum(int arr[]) {
        // code here
        int res = 0 ;
        
        // for edge case ---->> length is less than 2
        
        //if (arr.length < 2) return 0;

        for(int i = 0;i<arr.length-1;i++){
            res = Math.max(res,arr[i]+arr[i+1]);
        }
        return res;
    }
}
