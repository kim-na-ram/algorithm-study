class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev = 0;
        boolean[] adjArr = new boolean[nums.size()];
        for(int i = 0; i <= nums.size() - k; i++) {
            prev = nums.get(i);
            boolean isAdjacent = true;
            for(int j = i + 1; j < i + k; j++) {
                if(prev < nums.get(j)) {
                    prev = nums.get(j);
                } else isAdjacent = false;
            }

            if(isAdjacent) adjArr[i] = true;
        }

        for(int i = 0; i < nums.size() - k; i++) {
            if(adjArr[i] && adjArr[i + k]) return true;
        }

        return false;
    }
}