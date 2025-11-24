class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answerList = new ArrayList<>();
        
        int val = 0;
        for(int num : nums) {
            val = ((val * 2) + num) % 5;
            answerList.add(val == 0);
        }

        return answerList;
    }
}