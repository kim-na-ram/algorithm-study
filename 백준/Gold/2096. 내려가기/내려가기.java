import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] minDp = new int[N + 1][3];
        int[][] maxDp = new int[N + 1][3];

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // a
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + a;
            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + a;

            // b
            maxDp[i][1] = Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2])) + b;
            minDp[i][1] = Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][1], minDp[i - 1][2])) + b;

            // c
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + c;
            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + c;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            max = Math.max(max, maxDp[N][i]);
            min = Math.min(min, minDp[N][i]);
        }

        System.out.print(max + " " + min);
    }
}