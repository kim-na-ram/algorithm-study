import java.io.*;
import java.util.*;

class Main {
    public static int n, m;
    public static Set<Integer> friendSet;
    public static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        friendSet = new HashSet<>();
        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list[a].add(b);
            list[b].add(a);
        }

        bfs();

    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<int[]>();
        boolean[] visited = new boolean[n + 1];

        q.offer(new int[]{1, 0});
        visited[1] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int studentNumber = cur[0];
            // 몇 다리를 걸친 친구인지
            int friendCount = cur[1];

            if(studentNumber != 1 && friendCount <= 2)
                friendSet.add(studentNumber);

            for(int friendNumber : list[studentNumber]) {
                if(visited[friendNumber]) continue;

                q.offer(new int[]{friendNumber, friendCount + 1});
                visited[friendNumber] = true;
            }
        }
        
        System.out.println(friendSet.size());
    }
}