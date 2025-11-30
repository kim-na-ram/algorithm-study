class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for(int num : nums) total += num;

        long target = total % p;
        if (target == 0) return 0;

        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);

        long prefix = 0;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int need = (int)((prefix - target + p) % p);

            if(hm.containsKey(need)) {
                n = Math.min(n, i - hm.get(need));
            }

            hm.put((int)prefix, i);
        }

        return n == nums.length ? -1 : n;
    }
}