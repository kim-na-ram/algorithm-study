import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> q = new LinkedList<Integer>();
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 1; i <= order.length; i++) {
            q.offer(i);
        }
        
        int result = 0;
        
        for(int i = 0; i < order.length; i++) {
            if(!stk.isEmpty() && stk.peek() == order[i]) {
                stk.pop();
                result++;
                continue;
            }
            while(!q.isEmpty()) {
                if(q.peek() < order[i]) stk.push(q.poll());
                else if(q.peek() == order[i]) { q.poll(); result++; break; } else {
                    return result;
                }
            }
        }
        
        return result;
    }
}