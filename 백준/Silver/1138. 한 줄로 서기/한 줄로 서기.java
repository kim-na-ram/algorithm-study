import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> line = new ArrayList<>();
        for(int i = N; i >= 1; i--) {
			line.add(arr[i], i);
		}

        StringBuilder sb = new StringBuilder();
		for(Integer e: line)
            sb.append(e + " ");
		System.out.println(sb);
    }
}