import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> hm = new HashMap<>();
        PriorityQueue<Words> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.preq == o2.preq) {
                if(o1.word.length() == o2.word.length()) {
                    return o1.word.compareTo(o2.word);
                }
                return o2.word.length() - o1.word.length();
            }
            return o2.preq - o1.preq;
        });
        
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length() >= M)
                hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        
        for(String word: hm.keySet()) {
            pq.offer(new Words(word, hm.get(word)));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll().word).append("\n");
        }

        System.out.print(sb.deleteCharAt(sb.length() - 1));
    }
}

class Words {
    String word;
    int preq;
    
    public Words(String word, int preq) {
        this.word = word;
        this.preq = preq;
    }
}