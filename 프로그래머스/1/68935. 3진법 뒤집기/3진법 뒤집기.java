import java.util.*;

class Solution {
public int solution(int n) {
        String ans = "";
        int answer = 0;
        
        while(n > 0) {
            ans += n % 3;
            n /= 3;
        }
            
        answer = Integer.parseInt(ans, 3);
        return answer;
    }
}