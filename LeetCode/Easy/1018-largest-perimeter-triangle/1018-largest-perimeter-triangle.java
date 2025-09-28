class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        int max = 0;
        for(int i = nums.length - 1; i >= 2; i--) {
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