import java.util.*;
import java.io.*;

class Main {
    public static int N, M;
    public static int[] rank;
    public static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        rank = new int[N + 1];
        list = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<Integer>();

        StringTokenizer st;
        while(M --> 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            rank[B]++;
        }

        bfs();
    }

    public static void bfs() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(rank[i] == 0) {
				q.offer(i);
			}
		}
        
		while(!q.isEmpty()) {
			int current = q.poll();
			
			sb.append(current + " ");
			for(int next : list[current]) {
				rank[next]--;
				if(rank[next] == 0) {
					q.offer(next);
				}
			}
		}

        System.out.println(sb.toString());
    }
}