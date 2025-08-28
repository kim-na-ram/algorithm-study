import java.util.ArrayList;

class Solution {
    
    private static ArrayList<Integer>[] pylon;
    private static boolean[] check;
    private static int numOfNodes;
    
    public int solution(int n, int[][] wires) {
        
        int idx = 0;
        int answer = Integer.MAX_VALUE;
        
        pylon = new ArrayList[n + 1];
        check = new boolean[n + 1];
        
        while(idx <= n) {
        
            for(int i = 0; i < n + 1; i++)
                pylon[i] = new ArrayList<Integer>();
        
            for(int i = 0; i < wires.length; i++) {
                if(idx == i) continue;
                pylon[wires[i][0]].add(wires[i][1]);
                pylon[wires[i][1]].add(wires[i][0]);
            }
        
            numOfNodes = 0;
            dfs(1, -1);
            int res = Math.abs(n - 2 * numOfNodes);
	        answer = Math.min(res, answer);
	        idx++;
        }
        
        return answer;
    }
    
    static void dfs(int idx, int pa) {
        numOfNodes++;
        
        for(int nxt : pylon[idx])
            if(nxt != pa)
                dfs(nxt, idx);
    }
    
}