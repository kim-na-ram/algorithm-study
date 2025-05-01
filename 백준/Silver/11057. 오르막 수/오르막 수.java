import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int end = 10;
    public static int mod = 10_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] sum = new int[N + 1];
        int[][] dp = new int[N + 1][end];

        Arrays.fill(dp[0], 1);

        for(int i = 1; i < N + 1; i++) {
            for(int j = 9; j >= 0; j--) {
                if(j == 9) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = (dp[i - 1][j] + dp[i][j + 1]) % mod;
            }
        }

        System.out.println(dp[N][0]);
    }
}