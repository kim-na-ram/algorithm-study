import java.util.*;

class Solution {
    ArrayList<Integer>[] graph;
    int[] distance;
    boolean[] visited;
    int max = 0;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        bfs(1);
        
        int answer = 0;
        for(int i = 2; i <= n; i++) {
            if(max < distance[i]) {
                max = distance[i];
                answer = 1;
            } else if(max == distance[i]) answer++;
        }
        
        return answer;
    }
    
    public void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(s);
        visited[s] = true;
        distance[s] = 0;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : graph[now]) {
                if(!visited[next] && distance[next] > distance[now] + 1) {
                    visited[next] = true;
                    distance[next] = distance[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}