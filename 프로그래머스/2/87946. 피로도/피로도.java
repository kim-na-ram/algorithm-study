class Solution {
    public static int max = -1;
    public int solution(int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(k < dungeons[i][0]) continue;
            
            boolean[] visited = new boolean[dungeons.length];
            visited[i] = true;
            exploreDungeon(dungeons, visited, k - dungeons[i][1], 1);
        }

        return max;
    }
    
    public void exploreDungeon(int[][] dungeons, boolean[] visited, int k, int count) {
        max = Math.max(max, count);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] == true || k < dungeons[i][0]) continue;
            
            visited[i] = true;
            exploreDungeon(dungeons, visited, k - dungeons[i][1], count + 1);
            visited[i] = false;
        }
    }
}