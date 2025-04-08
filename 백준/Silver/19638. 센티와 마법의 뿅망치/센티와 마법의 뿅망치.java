import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int Hcenti = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int T_try = 0;
        
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> H = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < N; i++) {
            H.offer(Integer.parseInt(br.readLine()));
        }
        
        while(!H.isEmpty()) {
            
            if(H.peek() == 1 || T <= 0) {
                if(H.peek() >= Hcenti)
                    sb.append("NO").append("\n").append(H.peek());
                else sb.append("YES").append("\n").append(T_try);
                break;
            }
            
            if(H.peek() < Hcenti) {
                sb.append("YES").append("\n").append(T_try);
                break;
            } else {
                 int h = (int)(Math.floor(H.poll() / 2));
                 T -= 1;
                 T_try += 1;
                 
                 H.offer(h);
             }  
            
        }
        
        System.out.println(sb);

	}
}