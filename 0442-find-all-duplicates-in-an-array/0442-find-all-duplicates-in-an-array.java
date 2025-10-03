class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer> answers = new ArrayList<>(); 
        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : hm.keySet()) {
            if(hm.get(key) >= 2) answers.add(key);
        }

        return answers;
    }
}