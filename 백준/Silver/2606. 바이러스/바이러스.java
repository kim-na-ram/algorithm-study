import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        
        boolean[][] network = new boolean[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < pair; i++) {
            String s = br.readLine();
            int computer1 = Integer.parseInt(s.split(" ")[0]);
            int computer2 = Integer.parseInt(s.split(" ")[1]);
            
            network[computer1][computer2] = network[computer2][computer1] = true;
        }
        
        int answer = 0;
        queue.offer(1);
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int i = 1; i < n+1; i++) {
                if(network[now][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
        
    }
}