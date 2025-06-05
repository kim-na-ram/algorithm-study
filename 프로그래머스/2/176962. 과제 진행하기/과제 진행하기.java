import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Stack<int[]> stk = new Stack<>();
        String[] answer = new String[plans.length];
        
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                return s1[1].compareTo(s2[1]);
            }
        });
        
        int index = 0;
        
        for(int i = 0; i < plans.length; i++) {
            int startTime = stringTimeToIntTime(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            int endTime = startTime + playTime;
            
            if(i < plans.length - 1) {
                int nextStartTime = stringTimeToIntTime(plans[i+1][1]);
                
                if(endTime > nextStartTime) {
                    int restPlayTime = playTime - (nextStartTime - startTime);
                    stk.push(new int[]{i, restPlayTime});
                } else {
                    answer[index++] = plans[i][0];
                    
                    while(!stk.isEmpty()) {
                        int[] now = stk.pop();
                        if(endTime + now[1] <= nextStartTime) {
                            answer[index++] = plans[now[0]][0];
                            endTime = now[1] + endTime;
                        } else {
                            int restPlayTime = now[1] - (nextStartTime - endTime);
                            stk.push(new int[]{now[0], restPlayTime});
                            break;
                        }
                        
                    }
                }
            } else {
                answer[index++] = plans[i][0];
                while(!stk.isEmpty()) {
                    int[] now = stk.pop();
                    answer[index++] = plans[now[0]][0];
                }
            }
        }
        
        return answer;
    }
    
    public static int stringTimeToIntTime(String t) {
        return 60 * Integer.parseInt(t.split(":")[0]) + Integer.parseInt(t.split(":")[1]);
    }
}