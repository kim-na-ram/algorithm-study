import java.io.*;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        final int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        PriorityQueue<Integer> minPq = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        
        for(int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            
            if(maxPq.size() == minPq.size()) {
                maxPq.offer(t);

                if(!minPq.isEmpty() && maxPq.peek() > minPq.peek()) {
                    int tmp = minPq.poll();
                    minPq.offer(maxPq.poll());
                    maxPq.offer(tmp);
                }
            } else {
                if(maxPq.peek() > t) {
                    minPq.offer(maxPq.poll());
                    maxPq.offer(t);
                } else {
                    minPq.offer(t);
                }
            }
            
            sb.append(maxPq.peek()).append("\n");
        }

        System.out.print(sb.toString());
    }
}