import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<String> permutations;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int N = Integer.parseInt(s.split(" ")[0]);
        int M = Integer.parseInt(s.split(" ")[1]);
        
        int[] arr = new int[N+1];
        for(int i = 0; i < N + 1; i++) {
            arr[i] = i + 1;
        }
        
        int[] output = new int[N+1];
        boolean[] visited = new boolean[N+1];
        permutations = new ArrayList<String>();
        
        permutation(arr, output, visited, 0, N, M);
        
        Collections.sort(permutations);
        
        StringBuilder sb = new StringBuilder();
        for(String p: permutations) {
            sb.append(p).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            assemblePermuation(output, r);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            output[depth] = arr[i];
            permutation(arr, output, visited, depth+1, n, r);
            visited[i] = false;
        }
    }
    
    public static void assemblePermuation(int[] output, int r) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++) {
            sb.append(output[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        
        permutations.add(sb.toString());
    }
}