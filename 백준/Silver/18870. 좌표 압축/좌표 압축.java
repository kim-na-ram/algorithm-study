import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] coordinate_arr = new int[n];
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] temp_arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			
			coordinate_arr[i] = Integer.parseInt(st.nextToken());
			temp_arr[i] = coordinate_arr[i];
			
		}
		
		Arrays.sort(temp_arr);
		
		int index = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(!map.containsKey(temp_arr[i])) {
				map.put(temp_arr[i], index++);
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			if(map.containsKey(coordinate_arr[i])) {
				
				sb.append(map.get(coordinate_arr[i])).append(" ");
				
			}
		}
		
		System.out.println(sb);
		
	}

}
