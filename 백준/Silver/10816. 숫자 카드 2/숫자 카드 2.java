import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            if(!map.containsKey(card))
                map.put(card, 0);
            map.put(card, map.get(card) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int searchNumber = Integer.parseInt(st.nextToken());
            if(map.containsKey(searchNumber))
                sb.append(map.get(searchNumber) + " ");
            else
                sb.append(0 + " ");
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}