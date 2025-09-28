class Solution {
    public int largestPerimeter(int[] nums) {
        // 1 2 1
        // 1 1 10
        // 1 2 10

        Arrays.sort(nums);

        // if 1 1 2 10
        // then 10
        int max = 0;
        for(int i = nums.length - 1; i > 0; i--) {
            int right = i - 1;
            int left = right - 1;

            while(left >= 0 && left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    max = Math.max(max, (nums[left] + nums[right] + nums[i]));
                    left--;
                } else {
                    left++;
                    right--;
                }
            }
        }

        return max;
    }
}