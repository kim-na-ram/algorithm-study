import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 축제가 열리는 기간
        int N = Integer.parseInt(st.nextToken());

        // 채워야 하는 선호도의 합
        int M = Integer.parseInt(st.nextToken());

        // 마실 수 있는 맥주 종류의 수
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[K][2];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            // i번 맥주의 선호도
            arr[i][0] = Integer.parseInt(st.nextToken());
            // i번 맥주의 도수 레벨
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (
            (o1, o2) -> {
                if(o1[1] == o2[1])
                    return o2[0] - o1[0];
                else return o1[1] - o2[1];
            }
        ));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = 0;
        int answer = -1;
        for(int[] beer : arr) {
            total += beer[0];
            pq.offer(beer[0]);

            if(pq.size() > N) {
                total -= pq.poll();
            }

            if(pq.size() == N && total >= M) {
                answer = beer[1];
                break;
            }
        }

        System.out.print(answer);
    }
}