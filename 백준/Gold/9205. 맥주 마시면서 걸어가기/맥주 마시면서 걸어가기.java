import java.util.*;
import java.io.*;

/**
1박스에 20개의 맥주
50M를 가기 전에 맥주를 1병 마셔야만 함
(편의점에 갔다 온 직후에도 1병 마셔야 함)
*/
class Main {
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        ArrayList<int[]> pointList;
        ArrayList<ArrayList<Integer>> maps;
        
        sb = new StringBuilder();

        while(t --> 0) {
            // 편의점 개수
            int n = Integer.parseInt(br.readLine());

            pointList = new ArrayList<>();
            StringTokenizer st;
            
            // 상근이네 집 좌표, 편의점 좌표, 펜타포트 좌표
            for(int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                pointList.add(new int[]{x, y});
            }

            maps = new ArrayList<>();
            for(int i = 0; i < n + 2; i++) {
                maps.add(new ArrayList<>());
            }

            // 맨해튼 거리 1000m 이하를 만족하는 두 정점을 찾음.
            // 그리고 양방향 그래프로 서로 이어 줌.
            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (Manhattan(pointList.get(i), pointList.get(j)) <= 1000) {
                        maps.get(i).add(j);
                        maps.get(j).add(i);
                    }
                }
            }
            
            // bfs를 이용하여 집에서 페스티벌까지 갈 수 있는지 탐색.
            sb.append((bfs(maps, n) ? "happy" : "sad") + '\n');
        }

        System.out.print(sb.deleteCharAt(sb.length() - 1));
    }

    // 맨해튼 거리
    public static int Manhattan(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public static boolean bfs(ArrayList<ArrayList<Integer>> maps , int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
 
        boolean[] visited = new boolean[n + 2];
        visited[0] = true;
 
        while (!q.isEmpty()) {
            int now = q.poll();
 
            if (now == n + 1) {
                return true;
            }
 
            for (int next : maps.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
 
        return false;
    }
}