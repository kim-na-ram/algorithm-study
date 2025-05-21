import java.util.*;
import java.io.*;

class Main {
    public static int N, X;
    public static List<int[]>[] maps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMX = br.readLine().split(" ");

        N = Integer.parseInt(NMX[0]);
        int M = Integer.parseInt(NMX[1]);
        X = Integer.parseInt(NMX[2]);

        maps = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++) {
            // int[] arr, arr[0] : End Point / arr[1] : Ti(소요 시간)
            maps[i] = new ArrayList<int[]>();
        }

        for(int i = 0; i < M; i++) {
            String[] SET = br.readLine().split(" ");

            int S = Integer.parseInt(SET[0]);
            int E = Integer.parseInt(SET[1]);
            int Ti = Integer.parseInt(SET[2]);
            
            maps[S].add(new int[]{E, Ti});
        }

        int maxDistance = 0;
        for(int i = 1; i <= N; i++) {
            int distanceToX = dijkstra(i, X);
            int distanceToStart = dijkstra(X, i);
            maxDistance = Math.max(maxDistance, distanceToX + distanceToStart);
        }

        System.out.println(maxDistance);
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        boolean[] checked = new boolean[N + 1];

        pq.offer(new int[]{start, 0});
        distance[start] = 0;

        while(!pq.isEmpty()) {
            int[] pos = pq.poll();
            int now = pos[0];
            int Ti = pos[1];

            if(checked[now]) continue;
            checked[now] = true;

            for(int[] next : maps[now]) {
                if(distance[next[0]] > distance[now] + next[1] && !checked[next[0]]) {
                    distance[next[0]] = distance[now] + next[1];
                    pq.offer(new int[]{next[0], distance[next[0]]});
                }
            }
        }

        return distance[end];
    }
}