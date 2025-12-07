class Solution {
    public int countOdds(int low, int high) {
        int answer = 0;

        int n = high - low + 1;
        // 둘 다 짝수일 때
        if(low % 2 == 0 && high % 2 == 0) {
            answer = (int) Math.floor((double)n / (double)2);
        } else if(low % 2 == 0 || high % 2 == 0) {
            answer = n / 2;
        } else {
            answer = (int) Math.ceil((double)n / (double)2);
        }

        return answer;
    }
}