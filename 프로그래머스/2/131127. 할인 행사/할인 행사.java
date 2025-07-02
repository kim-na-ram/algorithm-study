import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        
        int count = 0;
        
        for(int i = 0; i < discount.length; i++) {
            
            if(!map.containsKey(discount[i])) {
                map.put(discount[i], 0);
            }
            
            map.put(discount[i], map.get(discount[i]) + 1);
            
            if(i >= 9) {
                boolean check = true;
                if(i - 10 >= 0) {
                    map.put(discount[i - 10], map.get(discount[i - 10]) - 1);
                }
                
                for(int j = 0; j < want.length; j++) {
                    if (!map.containsKey(want[j])) {
                        check = false;
                        break;
                    }
                    if (map.get(want[j]) < number[j]) {
                        check = false;
                        break;
                    }
                }
                if(check) count++;
            }
        }
        
        return count;
    }
}