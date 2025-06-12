import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> redundant = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            redundant.put(tangerine[i], redundant.getOrDefault(tangerine[i], 0) + 1);
        }
        
        int answer = 0;
        
        List<Integer> keySet = new ArrayList<>(redundant.keySet());
        keySet.sort((o1, o2) -> redundant.get(o2).compareTo(redundant.get(o1)));

        for (int key : keySet) {
            if(k <= 0) break;
            k -= redundant.get(key);
            answer++;
        }
        
        return answer;
    }
}