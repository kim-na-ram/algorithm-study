import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, ArrayList<String>> hm = new HashMap<>();

        int answer = 1;

        for(int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            if(!hm.containsKey(type)) {
                hm.put(type, new ArrayList<>());
            }
            hm.get(type).add(clothes[i][0]);
        }

        for(String type: hm.keySet()) {
            answer *= hm.get(type).size() + 1;
        }
        
        answer--;

        return answer;
    }
}
