class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        Arrays.fill(dp, max);

        // for(int i = n - 1; i >= 0; i--) {
        //     dp[i] = Math.max(dp[i], energy[i]);
        //     if(i - k >= 0) dp[i - k] = Math.max(dp[i - k], dp[i] + energy[i - k]);

        //     max = Math.max(dp[i], max);
        // }
        
        for(int i = 0; i < n; i++) {
            dp[i] = Math.max(dp[i], energy[i]);
            if(i + k < n) dp[i + k] = Math.max(dp[i + k], dp[i] + energy[i + k]);
            if(i + k >= n) max = Math.max(dp[i], max);
        }

        return max;
    }
}