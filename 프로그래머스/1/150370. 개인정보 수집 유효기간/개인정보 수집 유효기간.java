import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;
        StringTokenizer dt = new StringTokenizer(today, ".");

        long now = stToDate(dt);

        HashMap<String, Long> hm = new HashMap<>();

        // 약관 유효기간을 string -> long으로 변경 후 map에 저장
        for(String t: terms) {
            st = new StringTokenizer(t);
            
            String type = st.nextToken();
            long period = Long.parseLong(st.nextToken()) * 28;

            hm.put(type, period);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);

            dt = new StringTokenizer(st.nextToken(), ".");
            long start = stToDate(dt);
            String type = st.nextToken();

            // 수집 일자 + 약관 유효기간 <= 오늘
            if(start + hm.get(type) <= now) {
                // 파기해야하므로 list에 저장
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        for(int num: list) {
            answer[index++] = num;
        }

        return answer;
    }

    // string형 날짜를 long형으로 변경
    private long stToDate(StringTokenizer dt) {
        return Long.parseLong(dt.nextToken()) * 28 * 12 
            + Long.parseLong(dt.nextToken()) * 28 
            + Long.parseLong(dt.nextToken());
    }
}