import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int[][] arr = new int[priorities.length][2];
        int[][] sortArray = new int[priorities.length][2];
        
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for(int i = 0; i < priorities.length; i++) {
            arr[i][0] = i;
            arr[i][1] = priorities[i];
            queue.offer(arr[i]);
        }
        
        Arrays.sort(arr, new Comparator<int[]> () {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a2[1] - a1[1];
            }
        });
            
        int index = 0;
        int count = 1;
            
        while(!queue.isEmpty()) {
            if(queue.peek()[1] == arr[index][1]) {
                
                if(queue.peek()[0] == location) {
                    answer = count;
                }
                queue.poll();
                count++;
                index++;
            } else {
                queue.offer(queue.poll());
            }
        }
        
        return answer;
    }
}