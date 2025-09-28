class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        int max = 0;
        for(int i = nums.length - 1; i >= 2; i--) {
            int right = i - 1;
            int left = 0;

            while(left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    max = Math.max(max, (nums[right - 1] + nums[right] + nums[i]));
                    right--;
                } else {
                    left++;
                }
            }
        }

        return max;
    }
}