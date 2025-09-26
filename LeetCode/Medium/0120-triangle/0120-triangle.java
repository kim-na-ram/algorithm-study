class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // list.get(r).get(i)에서는 list.get(r+1).get(i) 혹은 list.get(r+1).get(i+1)로만 이동 가능
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        int[][] dp = new int[n][m];

        for(int r = 0; r < n - 1; r++) {
            Arrays.fill(dp[r], Integer.MAX_VALUE);
        }
        
        dp[0][0] = triangle.get(0).get(0);
        for(int r = 1; r < n; r++) {
            List<Integer> row = triangle.get(r);

            for(int i = 0; i < row.size(); i++) {
                int pos = row.get(i);
                
                if(i == 0)
                    dp[r][i] = dp[r - 1][i] + pos;
                else if(i == row.size() - 1)
                    dp[r][i] = dp[r - 1][i - 1] + pos;
                else
                    dp[r][i] = Math.min(dp[r - 1][i - 1] + pos, dp[r - 1][i] + pos);
            }
        }

        int min = dp[n - 1][0];
        for(int i = 1; i < m; i++) {
            min = Math.min(dp[n - 1][i], min);
        }

        return min;
    }
}