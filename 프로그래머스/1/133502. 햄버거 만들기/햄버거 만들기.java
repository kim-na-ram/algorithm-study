import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stk = new Stack<>();
        
        for(int i : ingredient) {
            stk.push(i);
            
            if(stk.size() >= 4) {
				int size = stk.size();
				if(stk.get(size - 1) == 1
						&& stk.get(size - 2) == 3
						&& stk.get(size - 3) == 2
						&& stk.get(size - 4) == 1) {
					answer++;
					stk.pop();
					stk.pop();
					stk.pop();
					stk.pop();
				}
            }
        }
        return answer;
    }
}