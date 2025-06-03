import java.util.*;
import java.io.*;

class Main {
    public static int idx = 0;
    public static int[] lis, wires;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        wires = new int[N];
        lis = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            wires[i] = Integer.parseInt(st.nextToken());
        }

        lis[idx++] = wires[0];
        for(int i = 0; i < N; i++) {
            if(lis[idx - 1] < wires[i]) lis[idx++] = wires[i];
            else binarySearch(wires[i]);
        }

        System.out.println(N - idx);
    }

    public static void binarySearch(int search) {
        int low = 0;
        int high = idx - 1;
        while(low <= high) {
            int mid = (low + high) / 2;

            if(lis[mid] <= search) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        lis[low] = search;
    }
}