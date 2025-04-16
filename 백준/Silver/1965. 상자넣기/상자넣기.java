import java.util.*;
import java.io.*;

class Main {
    public static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] boxes = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }
        
        lis = new int[n + 1];
        int len = 0;
        lis[len++] = boxes[0];
        for(int i = 1; i < n; i++) {
            if(lis[len - 1] < boxes[i]) {
                lis[len++] = boxes[i];
            } else {
                int idx = binarySearch(0, len, boxes[i]);
                lis[idx] = boxes[i];
            }
        }

        System.out.println(len);
    }

    public static int binarySearch(int start, int end, int num) {
        int mid = 0;
        while(start < end) {
            mid = (start + end) / 2;

            if(lis[mid] >= num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}