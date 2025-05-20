import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        // 심사대 개수
        int N = Integer.parseInt(NM[0]);
        // 입국심사 받을 사람 수
        int M = Integer.parseInt(NM[1]);

        long[] T = new long[N];

        for(int k = 0; k < N; k++) {
            T[k] = Integer.parseInt(br.readLine());
        }

        long low = 0;
        long high = M * T[N - 1];
        
        while(low <= high) {
            long mid = (low + high) / 2;

            long cnt = 0;
            for(long Tk : T) {
                cnt += mid / Tk;
                if(cnt >= M) break;
            }

            if(cnt >= M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }
}