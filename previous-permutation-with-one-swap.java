class Solution {
    public int[] prevPermOpt1(int[] arr) {
        for(int i=arr.length-1;i>=0;i--){
            int largest=0;
            int largestIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i] && arr[j]>largest){
                    largest=arr[j];
                    largestIndex=j;
                }
            }
            if(largest>0){
                int temp=arr[i];
                arr[i]=arr[largestIndex];
                arr[largestIndex]=temp;
                return arr;
            }

        }
        return arr;
    }
}
