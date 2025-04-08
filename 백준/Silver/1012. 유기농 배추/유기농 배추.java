import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    public static int N, M, K, count;
    public static int[][] farm;
    public static boolean[][] visited;
    
    public static void dfs(int i, int j) {
        
        visited[i][j] = true;
        
        if(checkCabbage(i - 1, j)) {
            farm[i - 1][j] = count;
            dfs(i - 1, j);
        }
            
        if(checkCabbage(i + 1, j)) {
            farm[i + 1][j] = count;
            dfs(i + 1, j);
        }
            
        if(checkCabbage(i, j - 1)) {
            farm[i][j - 1] = count;
            dfs(i, j - 1);
        }
            
        if(checkCabbage(i, j + 1)) {
            farm[i][j + 1] = count;
            dfs(i, j + 1);
        }
            
        
    }
    
    public static boolean checkCabbage(int row, int col) {
        
        if(row >= N || col >= M || row < 0 || col < 0)
            return false;
        if(farm[row][col] != 1 || visited[row][col] == true)
            return false;
            
        return true;
        
    }
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		
		StringBuilder sb = new StringBuilder();
		
		while(T --> 0) {
		
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		    N = Integer.parseInt(st.nextToken());
		    M = Integer.parseInt(st.nextToken());
		    K = Integer.parseInt(st.nextToken());
		
		    farm = new int[N][M];
		    visited = new boolean[N][M];
		    
		    count = 0;
		    
		    for(int i = 0; i < K; i++) {
		    	st = new StringTokenizer(br.readLine(), " ");
		    	int x = Integer.parseInt(st.nextToken());
		    	int y = Integer.parseInt(st.nextToken());
		    	
		    	farm[x][y] = 1;
		    }
		
		    for(int i = 0; i < N; i++)
		        for(int j = 0; j < M; j++)
		            if(farm[i][j] == 1 && visited[i][j] == false) {
        		        count++;
        		        dfs(i, j);
		            }
		            
		    sb.append(count).append("\n");
	    }
	    
	    System.out.println(sb);
	
	}
}