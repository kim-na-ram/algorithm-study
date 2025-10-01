class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i = 0; i < nums.length; i++) {
            if(dp[i] != -1) {
                for(int j = 1; j <= nums[i]; j++) {
                    if(i + j < nums.length) dp[i + j] = i;
                }
            }
        }

        return dp[nums.length - 1] == -1 ? false : true;
    }
}