class Solution {
    public int countCollisions(String directions) {
        final int n = directions.length();
        int answer = 0, left = 0, right = n - 1;

        while(left < n && directions.charAt(left) == 'L') left++;
        while(right >= left && directions.charAt(right) == 'R') right--;
        for(int i = left; i <= right; i++) {
            if(directions.charAt(i) != 'S') answer++;
        }
        return answer;
    }
}