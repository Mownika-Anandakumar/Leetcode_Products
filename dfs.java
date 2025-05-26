import java.util.*;

class Solution {
    private int dfs(int curr, List<List<Integer>> adj, int[] visited, int[][] longest, String colors) {
        if (visited[curr] == 1) // Cycle found
            return Integer.MAX_VALUE;
        
        if (visited[curr] == 0) { // Visiting for 1st time
            visited[curr] = 1;
            for (int nbr : adj.get(curr)) {
                int res = dfs(nbr, adj, visited, longest, colors);
                if (res == Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                
                // Iterate for each color for the current nbr and update max_len for each color at current node
                for (int i = 0; i < 26; ++i)
                    longest[i][curr] = Math.max(longest[i][curr], longest[i][nbr]);
            }
            longest[colors.charAt(curr) - 'a'][curr]++;
            visited[curr] = 2;
        }
        return longest[colors.charAt(curr) - 'a'][curr];
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        for (int[] edge : edges)
            adj.get(edge[0]).add(edge[1]);

        int[][] longest = new int[26][n];
        
        //    longest: Table to store the count of each color from a given node
        //    longest[i][j]=X: There are 'X' number of 'i' color nodes from current node 'j'
        
        // Perform DFS from each node and maximize color length
        int maxColorLength = 0;
        int[] visited = new int[n];
        
        //    3-color method is used to detect cycle in directed graph.
        //    0: Unvisited
        //    1: Visited & Processing
        //    2: Visited & Processed
        
        for (int i = 0; i < n; ++i) {
            int res = dfs(i, adj, visited, longest, colors);
            if (res == Integer.MAX_VALUE)
                return -1;
            maxColorLength = Math.max(maxColorLength, res);
        }
        return maxColorLength;
    }
}
