import java.util.*;
import java.io.*;

class Main {
    public static int N, C;
    public static int[] x;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 집의 개수
        N = sc.nextInt();
        // 공유기 개수
        C = sc.nextInt();

        x = new int[N];
        for(int i = 0; i < N; i++)
            x[i] = sc.nextInt();

        Arrays.sort(x);

        int low = 1;
        int high = x[N - 1] - x[0] + 1;

        while(low < high) {
            int mid = (low + high) / 2;

            if(isPossibleInstall(mid) < C) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }

    public static int isPossibleInstall(int dis) {
        int count = 1;
        int lastLocate = x[0];

        for(int i = 1; i < N; i++) {
            int locate = x[i];

            if(locate - lastLocate >= dis) {
                count++;
                lastLocate = locate;
            }
        }

        return count;
    }
}