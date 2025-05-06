import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        int low = 0;
        int high = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, tree[i]);
        }

        int answer = 0;
        while(low <= high) {
            int mid = (low + high) / 2;

            long count = 0;
            for(int h : tree) {
                count += h - mid > 0 ? h - mid : 0;
            }

            if(count >= M) {
                // H를 더 올리기 위해
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}