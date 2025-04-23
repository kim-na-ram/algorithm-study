import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] coin = new int[n];
        int[] dp = new int[k + 1];
        
        for(int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int j = 0; j < n; j++) {
            for(int i = 1; i <= k; i++) {
                if(coin[j] == i) dp[i] += 1;
                if(coin[j] < i) dp[i] += dp[i - coin[j]];
            }
        }

        System.out.println(dp[k]);
    }
}