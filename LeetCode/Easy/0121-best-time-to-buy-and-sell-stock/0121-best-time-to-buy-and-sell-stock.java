class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int n = prices.length;
        int[] dp = new int[n + 1];
        
        dp[0] = prices[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            if(answer < prices[i] - dp[i]) {
                answer = prices[i] - dp[i];
            }
        }

        return answer;
    }
}