import java.util.*;

/**
 * if) N = 1
 * 1, 2, 3, 4, 5, ... 9 => 9
 * dp[1][0] = 0 / dp[1][1] = 1 / dp[1][2] = 1 / ... / dp[1][8] = 1 / dp[1][9] = 1
 * if) N = 2
 * dp[2][0] = 10 ==> dp[1][1] = 1;
 * dp[2][1] = 21 ==> dp[1][0] + dp[1][2] == 1;
 * dp[2][2] = 12, 32 ==> dp[1][1] + dp[1][3] = 2
 * ...
 * dp[2][8] = 2 ==> 78, 98 ==> dp[1][7] + dp[1][9]
 * dp[2][9] = 1 ==> 89 ==> dp[1][8]
 */
class Main {
    public static int max = 10;
    public static int mod = 1_000_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        long sum = 0;
        
        long[][] dp = new long[N + 1][10];
        Arrays.fill(dp[1], 1);
        
        // 0으로 시작할 수는 없으므로 
        dp[1][0] = 0;
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < max; j++) {
                if(j - 1 < 0) dp[i][j] = dp[i - 1][j + 1] % mod;
                else if(j + 1 >= max) dp[i][j] = dp[i - 1][j - 1] % mod;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        for(int i = 0; i < max; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum % mod);
    }
}