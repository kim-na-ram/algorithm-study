import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    for(int j = 0; j < n; j++)
		        list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list, new Comparator<Integer>() {
		    @Override
		    public int compare(Integer a, Integer b) {
		        return b - a;
		    }
		});
		
		System.out.println(list.get(n-1));
	}
}
