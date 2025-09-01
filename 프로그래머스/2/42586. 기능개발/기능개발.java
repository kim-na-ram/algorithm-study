import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> develop = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < progresses.length; i++) {
            
            int rest = 100 - progresses[i];
            int days = 0;
            if(rest % speeds[i] != 0) {
                days = rest / speeds[i] + 1;
            } else {
                days = rest / speeds[i];
            }
            
            develop.offer(days);
            sb.append(days).append(" ");
            
        }
        
        System.out.println("queue : " + sb);
        
        ArrayList<Integer> result = new ArrayList<>(); 
        
        int count = 1;
        int prev = develop.poll();
        
        while(!develop.isEmpty()) {
            
            if(develop.peek() != null && prev >= develop.peek()) {
                
                count++;
                develop.poll();
                
                if(develop.isEmpty()) {
                    result.add(count);
                }
                
            } else if(develop.peek() != null && prev < develop.peek()) {
                
                result.add(count);
                prev = develop.poll();
                count = 1;
                
                if(develop.isEmpty()) {
                    result.add(count);
                }
                
            }
            
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < answer.length; i++)
            answer[i] = result.get(i);
        
        return answer;
        
    }
}