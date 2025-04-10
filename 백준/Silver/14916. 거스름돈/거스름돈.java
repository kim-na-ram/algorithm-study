import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();

        int[] dp = new int[r + 1];
        
        for(int i = 1; i <= r; i++) {
            if(i % 5 == 0) dp[i] = dp[i - 5] + 1;
            if(i % 5 != 0) {
                if(i % 2 == 0) dp[i] = dp[i - 2] + 1;
                // 5나 2로 나누어떨어지지 않으면 -1로 설정
                else dp[i] = -1;
                    
                int cnt = i / 5;
                while(cnt >= 0) {
                    int rest = i - 5 * cnt;
                    if((i - 5 * cnt) % 2 != 0) {
                        cnt--;
                    } else {
                        dp[i] = dp[5 * cnt] + dp[rest];
                        break;
                    }
                }
            }
        }

        System.out.println(dp[r]);
    }
}