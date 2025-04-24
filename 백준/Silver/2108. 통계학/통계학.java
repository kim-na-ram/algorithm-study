import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if (n % 2 != 0) { // n이 홀수라면
			
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(n);
			int[] array = new int[n];
			
			int mean = 0; // 산술평균
			int median = 0; // 중앙값
			int mode = 0; // 최빈값
			int range = 0; // 범위
			
			int sum = 0;
			int modecheck = 0;
			
			for(int i = 0; i < n; i++) {
				
				int num = Integer.parseInt(br.readLine());
				
				sum += num;

				array[i] = num;
				
				if(!map.containsKey(num)) {
					map.put(num, 1);
				} else {
					map.replace(num, map.get(num) + 1);
				}
				
			}
			
			mean = (int)Math.round((double)sum / (double)n);
			
			for(Integer e : map.keySet()) {
				
				sum += e;
				modecheck = Math.max(modecheck, map.get(e));
				
			}
			
			ArrayList<Integer> modelist = new ArrayList<Integer>();
			
			Arrays.sort(array);
			
			for(Integer e : array) {
				
				if(map.get(e) == modecheck && !modelist.contains(e)) {
					
					modelist.add(e);
					
				}
				
			}
			
			if (modelist.size() > 1) {
				
				mode = modelist.get(1);
				
			} else {
				
				mode = modelist.get(0);
				
			}
			
			median = array[n / 2];
			range = array[n-1] - array[0];
			
			System.out.println(mean + "\n" + median + "\n"
					+ mode + "\n" + range);
			
		}
		
	}
}
