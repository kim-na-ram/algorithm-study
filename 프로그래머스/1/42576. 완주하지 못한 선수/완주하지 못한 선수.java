import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {        
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])) {
                map.replace(participant[i], map.get(participant[i])+1);
            } else {
                map.put(participant[i], 1);
            }
        }
        
        for(int i = 0; i < completion.length; i++) {
            
            if(map.containsKey(completion[i])) {
                map.replace(completion[i], map.get(completion[i])-1);
            }
            
        }
        
        for(String e : map.keySet()) {
            if(map.get(e) == 1) {
                answer = e;
            }
        }

        return answer;
    }
}