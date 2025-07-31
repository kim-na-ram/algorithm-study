import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 시험지 개수
        int N = Integer.parseInt(st.nextToken());

        // 그룹의 수
        int K = Integer.parseInt(st.nextToken());

        int[] xArr = new int[N];
        int min = Integer.MAX_VALUE;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            xArr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, xArr[i]);
            max += xArr[i];
        }
        
        while(min <= max) {
            int mid = (min + max) / 2;

            int groupSum = 0;
            int groupCount = 1;
            for(int i = 0; i < N; i++) {
                groupSum += xArr[i];
                
                if(mid <= groupSum) {
                    groupCount++;
                    groupSum = 0;
                }
            }

            // 만약 해당 최솟값으로 만든 그룹이 K개보다 많다면
            if(groupCount > K) {
                min = mid + 1;
            }
            // 최솟값으로 만든 그룹이 K개보다 작다면
            // 최솟값이 높은 것이니까 max를 낮춤
            else {
                max = mid - 1;
            }
        }
        
        System.out.println(max);
    }
}