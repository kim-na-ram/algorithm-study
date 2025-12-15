class Solution {
    public long getDescentPeriods(int[] prices) {
        int smooth = 1;
        long answer = 1;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i - 1] - prices[i] == 1) {
                smooth++;
            } else {
                smooth = 1;
            }

            answer += smooth;
        }

        return answer;
    }
}