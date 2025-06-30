import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> map = new HashMap<>();
        
        int length = keymap.length;
        for(int i = 0; i < length; i++) {
            char[] characters = keymap[i].toCharArray();
            int charLength = characters.length;
            for(int j = 0; j < charLength; j++) {
                String c = Character.toString(characters[j]);
                int score = j + 1;
                if(map.containsKey(c)) {
                    if(map.get(c) > score) {
                        map.replace(c, score);
                    }
                } else {
                    map.put(c, score);
                }
            }
        }
        
        int targetsLength = targets.length;
        int[] answer = new int[targetsLength];
        for(int i = 0; i < targetsLength; i++) {
            char[] characters = targets[i].toCharArray();
            int charLength = characters.length;
            for(int j = 0; j < charLength; j++) {
                if(map.containsKey(Character.toString(characters[j]))) {
                    answer[i] += map.get(Character.toString(characters[j]));
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}