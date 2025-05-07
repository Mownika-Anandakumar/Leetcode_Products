import java.util.*;

public class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;

        // Priority queue: [time, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

        // Directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Visited set to prevent reprocessing
        Set<String> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int time = top[0];
            int row = top[1];
            int col = top[2];

            // Check if target cell is reached
            if (row == rows - 1 && col == cols - 1) {
                return time;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check bounds and if not visited
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    String key = newRow + "," + newCol;
                    if (!visited.contains(key)) {
                        int newTime = Math.max(time, moveTime[newRow][newCol]) + 1;
                        pq.offer(new int[]{newTime, newRow, newCol});
                        visited.add(key);
                    }
                }
            }
        }

        return -1; // If destination is unreachable
    }
}
