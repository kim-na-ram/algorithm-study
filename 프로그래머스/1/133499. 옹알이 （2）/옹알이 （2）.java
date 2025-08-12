import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        Set<String> words = new HashSet<>();
        words.add("aya");
        words.add("ye");
        words.add("woo");
        words.add("ma");

        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            String now = "";
            String prev = "";
            boolean flag = false;
            for(int j = 0; j < babbling[i].length(); j++) {
                now += babbling[i].charAt(j);
                if (words.contains(now)) {
                    if(prev.equals(now)) break;
                    prev = now;
                    now = "";
                    flag = true;
                } else {
                    flag = false;
                }
            }
            
            if(flag) answer++;
        }

        return answer;
    }
}