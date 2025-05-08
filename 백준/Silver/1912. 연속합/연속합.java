import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        
        int max = sequence[0];
        dp[0] = sequence[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(sequence[i], dp[i - 1] + sequence[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}