import java.util.*;
import java.io.*;

/*
7 -> 7
7 -> 13
7 -> 6

14 -> 14
14 -> 3
14 -> 12

20 -> 14
20 -> 3
20 -> 12

13 -> 14
13 -> 3
13 -> 12

28 -> 6 = 34
17 -> 6 = 23
26 -> 6 = 32

34 -> 6 = 40
23 -> 6 = 29
32 -> 6 = 38

27 -> 6 = 33
16 -> 6 = 22
25 -> 6 = 31
*/
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) 
                break;
            
            int[][] arr = new int[n][3];
            
            StringTokenizer st;
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n][3];
            dp[0][0] = dp[0][1] = arr[0][1];
            dp[0][2] = arr[0][1] + arr[0][2];
            for(int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], Math.min(dp[i - 1][2], dp[i][0]))) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][1], Math.min(dp[i - 1][2], dp[i][1])) + arr[i][2];
            }
            
            sb.append(tc + ". " + dp[n - 1][1]).append("\n");
            tc++;
        }
        
        System.out.print(sb);
    }
}