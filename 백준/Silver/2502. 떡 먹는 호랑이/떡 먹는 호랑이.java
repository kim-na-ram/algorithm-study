import java.util.*;
import java.io.*;

/*
만약 D = 6, K = 41
dp[1] = 2
dp[2] = 7
dp[3] = 9 = dp[1] + dp[2]
dp[4] = 16 = dp[2] + dp[3]
dp[5] = 25 = dp[3] + dp[4]
dp[6] = 41 = 

dp[n] = dp[n - 1] + dp[n - 2]
*/
class Main {
    public static int[] answer;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 할머니가 넘어온 날
        int D = sc.nextInt();

        // 호랑이에게 준 떡의 개수
        int K = sc.nextInt();

        // 정답 저장
        answer = new int[2];

        int a = K / 2;
        int b = K - a;

        while(!recursive(D, a, b)) {
            a -= 1;
            b += 1;

            if(a >= K || b <= 0) break;
        }

        System.out.print(answer[0] + "\n" + answer[1]);
    }

    public static boolean recursive(int n, int a, int b) {
        if(a <= 0 || a > b) {
            return false;
        }

        if(n <= 3) {
            answer[0] = a;
            answer[1] = b;
            return true;
        }

        return recursive(n - 1, b - a, a);
    }
}