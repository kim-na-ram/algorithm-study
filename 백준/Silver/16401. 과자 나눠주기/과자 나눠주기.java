import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] MN = br.readLine().split(" ");
        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);

        int[] snacks = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snacks);
        
        int min = 1;
        int max = snacks[N - 1];

        while(min <= max) {
            int mid = (min + max) / 2;

            int count = 0;
            for(int snack : snacks) {
                if(snack >= mid) count += (snack / mid);
            }

            if(count < M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max);
    }
}