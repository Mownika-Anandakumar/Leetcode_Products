class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(pq.size()<k)
                {
                    pq.offer(matrix[i][j]);
                }
                else if(pq.peek()>matrix[i][j]){
                    pq.poll();
                    pq.offer(matrix[i][j]);
                }
            }
        }
        return pq.poll();
    }
}
