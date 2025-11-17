class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        // 입력 : 이진 배열 nums와 정수 k
        // 출력 : 모든 1이 최소 k의 거리를 두고 위치되어 있으면 true, 그 외엔 false

        boolean answer = true;
        int prev = nums[0] == 1 ? 0 : -1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(prev == -1 || i - prev - 1 >= k) prev = i;
                else {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}