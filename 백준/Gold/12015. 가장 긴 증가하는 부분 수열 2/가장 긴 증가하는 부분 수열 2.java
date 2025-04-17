import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sequence = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sequence[0] = arr[0];
        int len = 1;
        for(int i = 1; i < N; i++) {
            if(arr[i] > sequence[len - 1]) {
                sequence[len++] = arr[i];
            } else {
                int idx = binarySearch(sequence, 0, len, arr[i]);
                sequence[idx] = arr[i]; 
            }
        }

        System.out.println(len);
    }

    public static int binarySearch(int[] sequence, int start, int end, int target) {
        while(start < end) {
            int mid = (start + end) / 2;

            if(sequence[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}