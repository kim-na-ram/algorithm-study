import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ND = br.readLine().split(" ");
        int N = Integer.parseInt(ND[0]);
        int D = Integer.parseInt(ND[1]);

        int[] dp = new int[D + 1];
        for(int i = 1; i <= D; i++) {
            dp[i] = i;
        }

        int[][] shortcuts = new int[N + 1][3];
        
        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            // start
            shortcuts[i][0] = Integer.parseInt(st.nextToken());
            
            // end
            shortcuts[i][1] = Integer.parseInt(st.nextToken());

            // shortcut
            shortcuts[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);

            for(int j = 1; j <= N; j++) {
                if(shortcuts[j][1] == i) {
                    dp[i] = Math.min(dp[i], dp[shortcuts[j][0]] + shortcuts[j][2]);
                }
            }
        }
        
        System.out.print(dp[D]);
    }
}