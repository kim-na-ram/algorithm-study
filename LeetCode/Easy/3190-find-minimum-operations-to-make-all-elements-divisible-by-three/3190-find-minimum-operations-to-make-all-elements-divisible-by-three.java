class Solution {
    public int minimumOperations(int[] nums) {
        // nums 배열의 아무 요소에서 1을 더하거나 빼
        // 모든 요소를 3으로 나누어 떨어지게 만드는 최소 연산 횟수를 반환

        int answer = 0;
        for(int i = 0; i < nums.length; i++) {
            int rest = nums[i] % 3;

            if(rest == 0) continue;
            else {
                answer += 3 - rest > rest ? rest : 3 - rest;
            }
        }

        return answer;
    }
}