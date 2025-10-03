class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);

        List<Integer> answers = new ArrayList<>();

        int pos = 0, end = nums.length;
        int duplicateCnt = 0;

        while(pos < end - 1) {
            if(nums[pos] == nums[pos + 1]) duplicateCnt++;

            if(nums[pos] != nums[pos + 1] || pos + 1 == end - 1) {
                if(duplicateCnt > 0) answers.add(nums[pos]);
                duplicateCnt = 0;
            }

            pos++;
        }

        return answers;
    }
}