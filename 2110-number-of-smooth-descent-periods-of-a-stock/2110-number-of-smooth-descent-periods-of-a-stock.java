class Solution {
    public long getDescentPeriods(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 1;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i - 1] - prices[i] == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        long answer = 0;
        for(int i = 0; i < prices.length; i++) {
            answer += dp[i];
        }

        return answer;
    }
}