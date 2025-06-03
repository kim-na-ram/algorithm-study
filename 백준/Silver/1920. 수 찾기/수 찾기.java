import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);
        
        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int search = Integer.parseInt(st.nextToken());
            
            int low = 0;
            int high = N - 1;
            while(low < high) {
                int mid = (low + high) / 2;
                
                if(A[mid] < search) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            
            sb.append(A[low] == search ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}