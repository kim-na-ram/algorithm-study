class Solution {
    public static int row, col = 4;
    int solution(int[][] land) {
        row = land.length;
        int[][] dp = new int[row + 1][col];
        
        for(int i = 1; i <= row; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i - 1][1];
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3])) + land[i - 1][2];
            dp[i][3] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + land[i - 1][3];
        }
        
        int max = 0;
        for(int i = 0; i < col; i++) {
            max = Math.max(max, dp[row][i]);
        }

        return max;
    }
}