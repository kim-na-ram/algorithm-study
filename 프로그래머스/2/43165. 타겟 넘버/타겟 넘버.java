class Solution {
    public int answer = 0;
    public int[] dx = new int[]{-1, 1};
    public void dfs(int number, int[] numbers, int target, int count) {
        if(count == numbers.length) {
            if(number == target) answer++;
            return;
        }
        
        for(int i = 0; i < 2; i++) {
            int sum = number + (dx[i] * numbers[count]);
            dfs(sum, numbers, target, count + 1);
        }
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers[0], numbers, target, 1);
        dfs(-1 * numbers[0], numbers, target, 1);
        
        return answer;
    }
}