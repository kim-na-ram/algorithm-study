import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int number = Integer.parseInt(br.readLine());
        
        int[] stairs = new int[number + 2];
        
        for(int i = 1; i < number + 1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int[][] dp = new int[number + 2][3];
        // 마지막 계단은 반드시 밟아야 함
        dp[number][1] = dp[number][2] = stairs[number];
        
        // 그렇기 때문에 마지막 계단 바로 전 계단은 두 칸 건넌 계단이어야만 함
        dp[number - 1][1] = stairs[number] + stairs[number - 1];
        dp[number - 1][2] = 0;
        
        for (int i = number - 2; i >= 1; i--) {
            dp[i][1] = Math.max(dp[i + 1][2], dp[i + 2][1]) + stairs[i];
            dp[i][2] = dp[i + 2][1] + stairs[i];
        }
        
        System.out.println(Math.max(dp[1][1], dp[2][1]));
    }
}