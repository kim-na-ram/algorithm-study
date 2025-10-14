class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        for(int i = 1; i < n; i++) {
            if(i <= 1) dp[i][0] = dp[i - 1][1] + nums[i];
            else dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + nums[i];
            dp[i][1] = dp[i - 1][0];
        }

        int answer = dp[n - 1][0] > dp[n - 1][1] ? dp[n - 1][0] : dp[n - 1][1];
        return answer;
    }
}