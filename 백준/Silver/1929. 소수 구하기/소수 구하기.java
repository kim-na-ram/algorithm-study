import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] mn = br.readLine().split(" ");
        int M = Integer.parseInt(mn[0]);
        int N = Integer.parseInt(mn[1]);
        
        boolean[] prime = new boolean[N + 1];
        
        prime[0] = prime[1] = true;
        for(int i = 2; i <= (int)Math.sqrt(N); i++) {
            if(prime[i]) continue;
            
            for(int j = i * i; j < N + 1; j = j + i) {
                prime[j] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = M; i <= N; i++) {
            if(!prime[i]) sb.append(i).append("\n");
        }
        
        System.out.println(sb);
    }
}