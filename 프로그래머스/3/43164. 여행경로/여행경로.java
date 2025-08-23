import java.util.*;

class Solution {
    public static boolean[] visited;
    public static LinkedList<String> result;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        result = new LinkedList<String>();
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(result);
        
        String[] answer = result.poll().split(" ");
        return answer;
    }
    
    public void dfs(int count, String start, String end, String[][] tickets) {
        if(count == tickets.length) {
            result.add(end);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(count + 1, tickets[i][1], end + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
        
        return ;
    }
}