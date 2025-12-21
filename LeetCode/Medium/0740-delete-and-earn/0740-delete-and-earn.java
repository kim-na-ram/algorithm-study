class Solution {
    public int deleteAndEarn(int[] nums) {
        // 1, 1, 1, 2, 4, 5, 5, 5, 6
        // if) 1, nums = [4, 5, 5, 5, 6], 3
        // if) 5, nums = [5, 5], 8
        // if) 5, nums = [5], 13
        // if) 5, nums = [], 18
        
        int n = 10_001;
        int[] values = new int[n];
        for(int num : nums) {
            values[num] += num;
        }

        int take = 0, skip = 0;
        for(int i = 0; i < n; i++) {
            int ti = skip + values[i];
            int si = skip > take ? skip : take;

            take = ti;
            skip = si;
        }

        return take > skip ? take : skip;
    }
}