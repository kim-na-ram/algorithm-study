class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        // 1 3 5 6 12

        int target = original;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(nums[mid] == target) {
                target = 2 * target;
                start = mid + 1;
                end = nums.length - 1;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return target;
    }
}