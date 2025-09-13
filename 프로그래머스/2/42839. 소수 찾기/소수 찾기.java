import java.util.*;

class Solution {
    static Set<Integer> permutations;
    public int solution(String numbers) {
        int len = numbers.length();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }
        
        permutations = new HashSet<>();
        for(int i = 1; i <= len; i++) {
            int[] output = new int[len];
            boolean[] visited = new boolean[len];
            permutation(arr, output, visited, 0, len, i);
        }
        
        int answer = 0;
        int[] p = permutations.stream().mapToInt(i -> i).toArray();
        for(int i = 0; i < p.length; i++) {
            boolean result = checkIsPrimeNumber(p[i]);
            if(result) answer++;
        }
        
        return answer;
    }
    
    public static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++) {
                sb.append(output[i]);
            }
        
            permutations.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            output[depth] = arr[i];
            permutation(arr, output, visited, depth + 1, n, r);
            visited[i] = false;
        }
    }
    
    public static boolean checkIsPrimeNumber(int n) {
        if(n < 2) return false;
        else if(n == 2) return true;
        else {
            for(int i = 2; i <= (int)Math.sqrt(n); i++) {
                if(n % i == 0) return false;
            }
        }
        
        return true;
    }
}