import java.util.*;
import java.io.*;

class Main {
    public static int N, M, K, X;
    public static int[] distance;
    public static ArrayList<Integer>[] maps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시의 개수
        N = Integer.parseInt(st.nextToken());

        // 도로의 개수
        M = Integer.parseInt(st.nextToken());

        // 거리 정보
        K = Integer.parseInt(st.nextToken());

        // 출발 도시의 번호
        X = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        maps = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            maps[i] = new ArrayList<Integer>();
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            maps[A].add(B);
        }

        dijkstra(X);
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        boolean[] visited = new boolean[N + 1];
        pq.offer(new int[]{start, 0});
        distance[start] = 0;

        while(!pq.isEmpty()) {
            int[] pos = pq.poll();
            int city = pos[0];
            int nowDistance = pos[1];

            if(visited[city]) break;
            visited[city] = true;

            for(int nextCity : maps[city]) {
                if(distance[nextCity] > nowDistance + 1) {
                    distance[nextCity] = nowDistance + 1;
                    pq.offer(new int[]{nextCity, distance[nextCity]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(distance[i] == K) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb.length() > 0 ? sb : -1);
    }
}