import java.util.List;
import java.util.Arrays;
class Solution {
    private long[][] memo; 
    private List<Integer> robots;
    private int[][] factories; 
    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        Collections.sort(robots);
        Arrays.sort(factories, (a, b) -> a[0] - b[0]);
        this.robots = robots;
        this.factories = factories;
        memo = new long[robots.size()][factories.length];
        return dfs(0, 0); 
    }
    private long dfs(int robotIndex, int factoryIndex) {
        if (robotIndex == robots.size()) {
   return 0;
        }
        if (factoryIndex == factories.length) {
            return Long.MAX_VALUE / 1000;
        }
        if (memo[robotIndex][factoryIndex] != 0) {

            return memo[robotIndex][factoryIndex];
        }
        long ans = dfs(robotIndex, factoryIndex + 1); 
        long distanceSum = 0; 
        for (int k = 0; k < factories[factoryIndex][1]; ++k) {
            if (robotIndex + k == robots.size()) {
                 break;
            }
            distanceSum += Math.abs(robots.get(robotIndex + k) - factories[factoryIndex][0]);
            ans = Math.min(ans, distanceSum + dfs(robotIndex + k + 1, factoryIndex + 1));
        }
        memo[robotIndex][factoryIndex] = ans; 
      return ans;
    }
}
