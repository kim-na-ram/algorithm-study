import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] colors = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }
        
        int[][] sum = new int[n][n];
        sum[n - 1][0] = colors[n - 1][0];
        sum[n - 1][1] = colors[n - 1][1];
        sum[n - 1][2] = colors[n - 1][2];

        for(int i = n - 2; i >= 0; i--) {
            sum[i][0] = Math.min(sum[i + 1][1] + colors[i][0], sum[i + 1][2] + colors[i][0]);
            sum[i][1] = Math.min(sum[i + 1][0] + colors[i][1], sum[i + 1][2] + colors[i][1]);
            sum[i][2] = Math.min(sum[i + 1][0] + colors[i][2], sum[i + 1][1] + colors[i][2]);
        }
        
        System.out.println(Math.min(sum[0][0], Math.min(sum[0][1], sum[0][2])));
    }
}