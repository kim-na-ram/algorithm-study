import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] preLectures = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            preLectures[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            preLectures[B].add(A);
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);
        for(int i = 1; i <= N; i++) {
            for(int preLecture : preLectures[i])
                dp[i] = Math.max(dp[preLecture] + 1, dp[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(dp[i] + " ");
        }
        
        System.out.print(sb);
    }
}