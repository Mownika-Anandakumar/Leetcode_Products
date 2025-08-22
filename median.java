class Solution {
    int median(int mat[][]) {
        // code here
        // traversing matrix with O(n*m)
        int row = mat.length;
        int col = mat[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0,r=0,c=0;i<row*col;i++)
        {
            list.add(mat[r][c]);
            c++;
            if(c == col)
            {
                c=0;
                r++;
            }
        }
        Collections.sort(list);
        
        return list.get(list.size()/2);
    }
}
