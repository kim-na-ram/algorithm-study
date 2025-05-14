class Solution {
    public int solution(int[] players, int m, int k) {
        int serverCount = 0;
        int[] server = new int[players.length];
        int[] removedServer = new int[players.length];
        
        int n0 = players[0] / m;
        if(n0 >= 1) {
            server[0] += n0;
            if(k < players.length)
                removedServer[k] = server[0];
            serverCount+= n0;
        }
        
        for(int i = 1; i < players.length; i++) {
            server[i] = server[i - 1];
            
            // 반납되는 서버 확인
            if(removedServer[i] > 0) {
                server[i] -= removedServer[i];
            }
            
            int ni = players[i] / m;
            if(ni >= 1 && server[i] < ni) {
                int x = ni - server[i];
                server[i] = ni;
                serverCount += x;
                if(i + k < players.length) 
                    removedServer[(i + k)] = x; 
            }
        }
        
        return serverCount;
    }
}