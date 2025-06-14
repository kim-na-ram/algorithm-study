import java.util.*;
import java.io.*;

class Main {
    public static int V, E;
    public static int[] distance;
    public static List<int[]>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        list = new ArrayList[V + 1];
        for(int i = 0; i <= V; i++) {
            list[i] = new ArrayList<int[]>();
        }

        int start = Integer.parseInt(br.readLine());

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new int[]{v, w});
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(distance[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void dijkstra(int x) {
        boolean[] checked = new boolean[V + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        pq.offer(new int[]{x, 0});
        distance[x] = 0;

        while(!pq.isEmpty()) {
            int[] pos = pq.poll();
            int v = pos[0];
            int w = pos[1];

            if(checked[v]) continue;
            checked[v] = true;

            for(int[] next : list[v]) {
                if(distance[next[0]] > next[1] + w) {
                    distance[next[0]] = next[1] + w;
                    pq.offer(new int[]{next[0], distance[next[0]]});
                }
            }
        }
        
    }
}