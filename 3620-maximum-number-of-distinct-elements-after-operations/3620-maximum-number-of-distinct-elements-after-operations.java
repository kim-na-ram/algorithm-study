class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        int last = Integer.MIN_VALUE;
        Set<Integer> distinctElements = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int start = Math.max(last + 1, nums[i] - k);
            int end = nums[i] + k;

            if(start <= end) {
                distinctElements.add(start);
                last = start;
            }
        }

        return distinctElements.size();
    }
}