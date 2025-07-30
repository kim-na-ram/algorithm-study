import java.util.*;
import java.io.*;
import java.math.BigInteger;

/*
 n이 1 ==> 1 
 |

 n이 2 ==> 3
 ||, =, ㅁ
 (2 * (n - 1)) + 1

 n이 3 ==> 5
 = > 2*2, | > 2*1, ㅁ > 2*2
 |||, |=, =|, |ㅁ, ㅁ|
 (2 * (n - 1)) - 1

 n이 4 ==> 11
 ||||, ==, ||=, =||, |=|, ||ㅁ, ㅁ||, |ㅁ|, =ㅁ, ㅁ=, ㅁㅁ
 (2 * (n - 1)) + 1

 n이 5 ==> 21
 |||||, ==|, =|=, |==, ㅁㅁ|, ㅁ|ㅁ, |ㅁㅁ, =|||, |=||, ||=|, |||=,
 ㅁ|||, |ㅁ||, ||ㅁ|, |||ㅁ, |=ㅁ, |ㅁ=, =|ㅁ, =ㅁ|, ㅁ|=, ㅁ=|
 (2 * (n - 1)) - 1
*/
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nMax = 250;
        BigInteger[] dp = new BigInteger[nMax + 1];
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);

        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = br.readLine();
            if(s == null) break;
            
            int n = Integer.parseInt(s);
            for(int i = 2; i <= n; i++) {
                if(dp[i] != null) continue;

                BigInteger result = dp[i - 1].multiply(new BigInteger("2"));
                if(i % 2 == 0) dp[i] = result.add(new BigInteger("1"));
                else dp[i] = result.subtract(new BigInteger("1"));
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb.deleteCharAt(sb.length() - 1));
    }
}