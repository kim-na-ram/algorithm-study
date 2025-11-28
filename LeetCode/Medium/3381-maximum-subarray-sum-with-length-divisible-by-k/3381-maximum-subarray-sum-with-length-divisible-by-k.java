class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        final long n = nums.length, INF = Long.MAX_VALUE / 2;
        long answer = -INF;
        long[] minSub = new long[k];

        for(int i = 0; i < k - 1; i++)
            minSub[i] = INF;
        
        minSub[k - 1] = 0;

        long prefix = 0;
        for(int i = 0; i < n; i++) {
            prefix += nums[i];
            int mod = i % k;
            answer = Math.max(answer, prefix - minSub[mod]);
            minSub[mod] = Math.min(prefix, minSub[mod]);  
        }

        return answer;
    }
}