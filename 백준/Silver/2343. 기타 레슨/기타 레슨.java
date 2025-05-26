import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int min = 0;
        int max = 0;
        int[] lectures = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            min = Math.max(lectures[i], min);
            max += lectures[i];
        }

        while(min <= max) {
            int mid = (min + max) / 2;
            
            int count = 1, sum = 0;
            for(int lecture : lectures) {
                if(sum + lecture <= mid) {
                    sum += lecture;
                } else {
                    count++;
                    sum = lecture;
                }
            }

            // 만약 블루레이가 M개보다 많다면
            if(count > M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(min);
    }
}