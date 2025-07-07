import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stk = new Stack<>();
        
        boolean flag = false;
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(stk.isEmpty() && (c == ')' || c == '}' || c == ']')) { flag = true; break; }
                else {
                    if(c == '(' || c == '{' || c == '[') stk.push(c);
                    else if(c == ')') {
                        if(!stk.isEmpty() && stk.peek() == '(') stk.pop();
                        else { flag = true; break; }
                    } else if(c == '}') {
                        if(!stk.isEmpty() && stk.peek() == '{') stk.pop();
                        else { flag = true; break; }
                    } else if(c == ']') {
                        if(!stk.isEmpty() && stk.peek() == '[') stk.pop();
                        else { flag = true; break; }
                    }
                }
            }
            
            if(stk.isEmpty() && !flag) answer++;
            else stk.clear();
            
            flag = false;
            s = s.substring(1, s.length()) + s.charAt(0);
        }
        
        return answer;
    }
}