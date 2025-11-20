class Solution {
    public int findFinalValue(int[] nums, int original) {
        int max = 0;
        Set<Integer> hs = new HashSet<>();

        for(int num : nums) {
            hs.add(num);
            max = max > num ? max : num;
        }

        while(original <= max && hs.contains(original)) {
            original = original * 2;
        }

        return original;
    }
}