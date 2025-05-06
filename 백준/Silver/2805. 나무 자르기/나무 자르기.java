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

        while(low < high) {
            int mid = (low + high) / 2;

            long sum = 0;
            for(int h : tree) {
                sum += h - mid > 0 ? h - mid : 0;
            }

            if(sum < M) {
                // H를 더 낮추기 위해
                high = mid;
            } else {
                // H를 더 높이기 위해
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }
}