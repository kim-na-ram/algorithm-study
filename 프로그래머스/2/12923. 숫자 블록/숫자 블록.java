import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int period = (int)(end - begin);
        
        int idx = period;
        int[] answer = new int[period + 1];
        
        Arrays.fill(answer, 1);
        if(begin == 1) answer[0] = 0;
        
        for(long i = end; i >= begin; i--) {
            for(int j = 2; j <= (int)Math.sqrt(end); j++) {
                if(i % j == 0) {
                    if(i / j > 10_000_000) {
                        answer[period] = j;
                        continue;
                    } else {
                        answer[period] = (int)(i / j);
                        break;
                    }
                }
            }
            
            period--;
        }
        
        return answer;
    }
}