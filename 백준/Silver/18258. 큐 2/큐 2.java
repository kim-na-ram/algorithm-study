import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");

            switch(cmd[0]) {
                case "push":
                    queue.addLast(Integer.parseInt(cmd[1]));
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.removeFirst()).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.get(0)).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.get(queue.size() - 1)).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}