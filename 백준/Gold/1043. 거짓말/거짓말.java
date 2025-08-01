import java.util.*;
import java.io.*;

/*
input ex)
4 5
1 1
1 1
1 2
1 3
1 4
2 4 1

output ex)
2

사람의 수 4
파티의 수 5
진실을 아는 사람의 수 1
진실을 아는 사람의 번호 1
0번 파티, 1번만 참여
1번 파티, 2번만 참여
2번 파티, 3번만 참여
3번 파티, 4번만 참여
4번 파티, 1, 4번 참여

=> 1번이 참여하는 모든 파티를 제외
===> 4 / 0
=> 1번이 참여하는 모든 파티에 참여하는 사람도 제외
===> 3

남은건 1, 2 => answer = 2

input ex)
3 4
1 3
1 1
1 2
2 1 2
3 1 2 3

output ex)
0

사람의 수 3
파티의 수 4
진실을 아는 사람의 수 1
진실을 아는 사람의 번호 3
0번 파티, 1번만 참여
1번 파티, 2번만 참여
3번 파티, 1, 2번 참여
4번 파티, 1, 2, 3번 참여

=> 3번이 참여하는 모든 파티를 제외
===> 4
=> 3번이 참여하는 모든 파티에 참여하는 사람도 제외
===> 0, 1, 3

남은건 x => answer = 0

*/

class Main {
    public static Queue<Integer> q;
    public static boolean[] checkedPeople, checkedParty;
    public static ArrayList<Integer>[] peoples, parties;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람의 수
        int N = Integer.parseInt(st.nextToken());
        // 파티의 수
        int M = Integer.parseInt(st.nextToken());
        
        // 사람과 사람이 참여하는 파티의 번호
        peoples = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            peoples[i] = new ArrayList<Integer>();
        }

        // 파티와 파티에 참여하는 사람의 번호
        parties = new ArrayList[M + 1];
        for(int i = 0; i <= M; i++) {
            parties[i] = new ArrayList<Integer>();
        }

        st = new StringTokenizer(br.readLine());
        // 진실을 아는 사람의 수
        int number = Integer.parseInt(st.nextToken());
        
        boolean[] truth = new boolean[N + 1];
        for(int i = 0; i < number; i++) {
            truth[Integer.parseInt(st.nextToken())] = true;
        }

        q = new LinkedList<Integer>();
        checkedPeople = new boolean[N + 1];
        checkedParty = new boolean[M + 1];
        
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            
            // 파티에 온 사람의 수
            number = Integer.parseInt(st.nextToken());
        
            // 파티에 온 사람의 번호
            for(int j = 0; j < number; j++) {
                int partyNumber = Integer.parseInt(st.nextToken());

                if(truth[partyNumber]) q.offer(i);
                
                peoples[partyNumber].add(i);
                parties[i].add(partyNumber);
            }
        }

        bfs();
        
        int answer = 0;
        for(int i = 1; i <= M; i++) {
            if(!checkedParty[i]) answer++;
        }
            
        System.out.print(answer);
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            // 진실을 아는 사람이 참여한 파티의 번호
            int current = q.poll();
            checkedParty[current] = true;

            // 진실을 아는 사람이 참여한 파티에 참여한 사람들
            for(int people : parties[current]) {
                if(checkedPeople[people]) continue;
                checkedPeople[people] = true;

                for(int party : peoples[people]) {
                    if(!checkedParty[party]) {
                        q.offer(party);
                    }
                }
            }
        }
    }
}