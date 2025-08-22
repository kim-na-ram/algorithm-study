import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            int sum = 0;
            for(int i = 0; i < N; i++) {
                sum += binarySearch(A[i], B);
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }

    public static int binarySearch(int target, int[] arr) {
        if(target < arr[0]) return 0;
        if(arr[arr.length - 1] < target) return arr.length;
        
        int min = 0;
        int max = arr.length - 1;

        while(min <= max) {
            int mid = (min + max) / 2;

            if(arr[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return min;
    }
}