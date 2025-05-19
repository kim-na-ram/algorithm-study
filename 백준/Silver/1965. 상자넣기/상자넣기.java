import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] boxes = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        int[] lcs = new int[n];
        int lcsLen = 0;

        lcs[lcsLen++] = boxes[0];
        
        for(int i = 1; i < n; i++) {
            if(lcs[lcsLen - 1] < boxes[i]) lcs[lcsLen++] = boxes[i];
            else {
                int low = 0;
                int high = lcsLen - 1;

                while(low < high) {
                    int mid = (low + high) / 2;

                    if(lcs[mid] < boxes[i]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                lcs[low] = boxes[i];
            }
        }
        
        System.out.println(lcsLen);
    }
}