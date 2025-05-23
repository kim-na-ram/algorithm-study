import java.util.*;
import java.io.*;

class Main {
    public static int N, H;
    public static int min, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NH = br.readLine().split(" ");
        N = Integer.parseInt(NH[0]);
        H = Integer.parseInt(NH[1]);
        min = N;

        // 석순
        int[] up = new int[N / 2];
        // 종유석
        int[] down = new int[N / 2];

        for(int i = 0; i < N / 2; i++) {
            up[i] = Integer.parseInt(br.readLine());
            down[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(up);
        Arrays.sort(down);

        for(int i = 1; i <= H; i++) {
            int conflict = binarySearch(i, up) + binarySearch(H - i + 1, down);
            if(min == conflict) count++;
            if(min > conflict) {
                count = 1;
                min = conflict;
            }
        }


        System.out.println(min + " " + count);
    }

    public static int binarySearch(int target, int[] hurdle) {
        int low = 0;
        int high = N / 2;

        while(low < high) {
            int mid = (low + high) / 2;

            if(hurdle[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return hurdle.length - high;
    }
}