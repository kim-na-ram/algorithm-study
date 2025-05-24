class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long[] sum1 = new long[sequence.length + 1];
        long[] sum2 = new long[sequence.length + 1];
        
        for(int i = 1; i < sum1.length; i++) {
            if(i % 2 == 0) sum1[i] = sum1[i - 1] + sequence[i - 1];
            else sum1[i] = sum1[i - 1] + -sequence[i - 1];
            
            if(sum1[i] < 0) sum1[i] = 0;
            answer = Math.max(sum1[i], answer);
        }
        
        for(int i = 1; i < sum2.length; i++) {
            if(i % 2 == 0) sum2[i] = sum2[i - 1] + -sequence[i - 1];
            else sum2[i] = sum2[i - 1] + sequence[i - 1];
            
            if(sum2[i] < 0) sum2[i] = 0;
            answer = Math.max(sum2[i], answer);
        }
        
        return answer;
    }
}