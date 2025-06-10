import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 지방의 수
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        
        // 요청된 예산
        int[] reqBudget = new int[N];
        for(int i = 0; i < N; i++) {
            reqBudget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, reqBudget[i]);
        }

        // 총 예산
        int totalBudget = Integer.parseInt(br.readLine());

        int min = 0;
        while(min <= max) {
            int mid = (min + max) / 2;
            
            long sum = 0;
            for(int i = 0; i < N; i++) {
                if(reqBudget[i] < mid) sum += reqBudget[i];
                else sum += mid;
            }

            // 만약 sum이 총 예산을 넘어간다면 
            if(totalBudget < sum) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max);
    }
}