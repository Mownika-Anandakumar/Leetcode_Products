class Solution {
    public int differenceOfSums(int n, int m) 
    {
        if(m==1) return (-1)*(n*(n+1))/2;
		
	int totalSum = (n*(n+1))/2;
		
	int divSum = 0;   
		
        for(int i=1;i<=n;i++)
            if(i%m==0) divSum+=i;
        
        int nonDivSum = totalSum-divSum; 
        
        return nonDivSum-divSum;        
    }
}
