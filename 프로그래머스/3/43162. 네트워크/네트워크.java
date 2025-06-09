import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public static List<List<Integer>> list;
    public static boolean[] visited;
    public static int answer;
    public int solution(int n, int[][] computers) {
        list = new ArrayList<>();
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && computers[i][j] == 1)
                    list.get(i).add(j);
            }
        }
        
        for(int i = 0; i < n; i++) {
            bfs(i, n);
        }
        
        return answer;
        
    }
    
    public static void bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        
        if(visited[start]) return ;
        visited[start] = true;
        answer++;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int i = 0; i < list.get(now).size(); i++) {
                if(!visited[list.get(now).get(i)]) {
                    visited[list.get(now).get(i)] = true;
                    queue.offer(list.get(now).get(i));
                }
            }
        }
    }
}