import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N + 1];
        List<Integer>[] prevJob = new ArrayList[N + 1];

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            prevJob[i] = new ArrayList<>();

            times[i] = Integer.parseInt(st.nextToken());
            int prevJobCount = Integer.parseInt(st.nextToken());
            for(int j = 0; j < prevJobCount; j++) 
                prevJob[i].add(Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            for(int prev : prevJob[i]) {
                if(prev != 0) dp[i] = Math.max(dp[i], dp[prev]);
            }

            dp[i] += times[i];
        }

        int result = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}