import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    
    PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> minQueue;
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        minQueue = new PriorityQueue<>();
        
        for(String op: operations) {
            String command = op.split(" ")[0];
            int number = Integer.parseInt(op.split(" ")[1]);
            
            if(command.contains("I")) {
                minQueue.offer(number);
                maxQueue.offer(number);
            } else if(command.contains("D")) {
                if(minQueue.isEmpty() || maxQueue.isEmpty())
                    continue;
                if(number > 0) {
                    int t = maxQueue.poll();
                    minQueue.remove(t);
                } else {
                    int t = minQueue.poll();
                    maxQueue.remove(t);
                }
            }
            
        }
        
        if(!maxQueue.isEmpty()) answer[0] = maxQueue.peek();
        if(!minQueue.isEmpty()) answer[1] = minQueue.peek();
        
        return answer;
    }
}