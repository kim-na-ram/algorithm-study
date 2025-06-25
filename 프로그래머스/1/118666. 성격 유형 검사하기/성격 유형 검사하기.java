import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> score = new HashMap<>();
        String[] types = {"RT", "CF", "JM", "AN"};
        
        for(int i = 0; i < types.length; i++) {
            char type1 = types[i].charAt(0);
            char type2 = types[i].charAt(1);
            
            score.put(type1, 0);
            score.put(type2, 0);
        }
        
        for(int i = 0; i < survey.length; i++) {
            char negative = survey[i].charAt(0);
            char positive = survey[i].charAt(1);
            
            int negativeScore = 0;
            int positiveScore = 0;
            
            if(choices[i] > 4) {
                positiveScore = choices[i] - 4;
            } else if(choices[i] < 4) {
                negativeScore = choices[i] - 4;
            }
            
            score.replace(positive, score.get(positive) + positiveScore);
            score.replace(negative, score.get(negative) + Math.abs(negativeScore));   
        }
        
        String answer = "";
        for(int i = 0; i < types.length; i++) {
            int type1 = score.get(types[i].charAt(0));
            int type2 = score.get(types[i].charAt(1));
            
            if(type1 > type2) {
                answer += types[i].charAt(0);
            } else if(type1 == type2) {
                int dict = Character.compare(types[i].charAt(0), types[i].charAt(1));
                if(dict < 0) {
                    answer += types[i].charAt(0);
                } else {
                    answer += types[i].charAt(1);
                }
            } else {
                answer += types[i].charAt(1);
            }
        }
        
        return answer;
    }
}