class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int min = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if(min > prices[i]) {
                min = prices[i];
            }

            if(answer < prices[i] - min) {
                answer = prices[i] - min;
            }
        }

        return answer;
    }
}