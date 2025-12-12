class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;

        while(start <= end) {
            if(nums[start] == val && nums[end] == val) {
                end--;
            } else if(nums[start] == val) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = nums[start];

                start++;
                end--;
            } else {
                start++;
            }
        }

        return start;
    }
}