class Solution {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        Arrays.sort(power);

        List<Integer> powerList = new ArrayList<>();
        List<Long> totalDamageList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int target = power[i];
            long sum = target;

            while(i + 1 < n && power[i + 1] == target) {
                i++;
                sum += target;
            }

            powerList.add(target);
            totalDamageList.add(sum);
        }

        long[] dp = new long[powerList.size() + 1];
        for(int i = powerList.size() - 1; i >= 0; i--) {
            long skip = dp[i + 1];
            long take = totalDamageList.get(i);

            int next = i + 1;
            while(next < powerList.size() 
                && powerList.get(next) - powerList.get(i) <= 2) {
                    next++;
            }

            take += dp[next];
            dp[i] = Math.max(skip, take);
        }

        return dp[0];
    }
}