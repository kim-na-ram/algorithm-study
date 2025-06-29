import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> q1 = new LinkedList<Character>();
        Queue<Character> q2 = new LinkedList<Character>();
        
        int index = 0;
        int end = s.length();
        
        for(int i = 0; i < end; i++) {
            char c = s.charAt(i);
            if(q1.isEmpty()) {
                q1.add(c);
            } else {
                if(q1.peek() == c) q1.add(c);
                else q2.add(c);                
            }
            
            if(q1.size() == q2.size()) {
                answer++;
                q1.clear();
                q2.clear();
            } else {
                if(i == end - 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}