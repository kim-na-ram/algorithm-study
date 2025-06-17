import java.util.*;

class Solution {
    public ArrayList<Integer>[] graph;
    public int[][] players;
    
    public int solution(int n, int[][] results) {
        graph = new ArrayList[n + 1];
        players = new int[n + 1][2];

        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < results.length; i++) {
            graph[results[i][0]].add(results[i][1]);
        }

        for(int i = 1; i < n + 1; i++) {
            bfs(i, n);
        }
        
        int answer = 0;
        for(int i = 1; i < n + 1; i++) {
            if(players[i][0] + players[i][1] == n - 1) answer++;
        }

        return answer;
    }

    public void bfs(int s, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(s);
        visited[s] = true;

        while(!q.isEmpty()) {
            int a = q.poll();

            for(int b : graph[a]) {
                if(visited[b]) continue;
                
                players[s][0]++;
                players[b][1]++;
                
                q.offer(b);
                visited[b] = true;
            }
        }
    }
}