import java.util.*;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // text를 공백을 기준으로 자르고
        // brokenLetters에 있는 요소가 포함되면 출력 불가능

        Set<String> letterSet = new HashSet<>();
        for(int i = 0; i < brokenLetters.length(); i++) {
            letterSet.add(brokenLetters.substring(i, i + 1));
        }

        int sum = 0;
        StringTokenizer st = new StringTokenizer(text);
        while(st.hasMoreTokens()) {
            String word = st.nextToken();

            boolean isBroken = false;
            for(String s : letterSet) {
                if(word.indexOf(s) != -1) {
                    isBroken = true;
                    break;
                }
            }

            if(!isBroken) sum++;
        }

        return sum;
    }
}