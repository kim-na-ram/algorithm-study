import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        while(t --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int best = Integer.MAX_VALUE;
            int count = 0;
            
            int low = 0;
            int high = n - 1;
            while(low < high) {
                int sum = arr[low] + arr[high];
                int gap = Math.abs(sum - K);
                
                if(best >= gap) {
                    if(best > gap) count = 0;
                    best = gap;
                    count++;
                }
                
                // 더한 값이 K보다 크다면
                if(sum > K) {
                    high--;
                } else {
                    low++;
                }
            }

            sb.append(count).append("\n");
        }
        
        System.out.print(sb);
    }

}