import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int i : scoville) {
            queue.offer(i);
        }
        
        int answer = 0;
        
        while(queue.size() > 1) {
            if(queue.peek() >= K) return answer;
            
            int first = queue.poll();
            int second = queue.poll();
            int after = first + (second * 2);
            
            queue.offer(after);
            
            answer++; // 섞으면 +1
        }
        
        if(queue.peek() < K) return -1;
        
        return answer;

    }
}