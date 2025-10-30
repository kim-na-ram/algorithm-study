class Solution {
    public int minNumberOperations(int[] target) {
        int count = 0;
        int[] dp = new int[target.length];
        dp[0] = target[0];        

        for(int i = 1; i < target.length; i++) {
            dp[i] = target[i - 1] == target[i] ? dp[i - 1] : target[i - 1] > target[i] ? dp[i - 1] : dp[i - 1] + (target[i] - target[i - 1]);
        }

        return dp[target.length - 1];
    }
}