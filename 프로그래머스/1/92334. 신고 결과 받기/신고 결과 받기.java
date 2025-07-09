import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, ArrayList<String>> reportedMap = new HashMap<>();
        Map<String, Integer> reportedId = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++) {
            reportedId.put(id_list[i], i);
        }
        
        for(int i = 0; i < report.length; i++) {
            String[] r = report[i].split(" ");
            
            if(reportedMap.containsKey(r[1])) {
                ArrayList<String> list = reportedMap.get(r[1]);
                if(!list.contains(r[0])) {
                    list.add(r[0]);
                    reportedMap.put(r[1], list);
                }
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(r[0]);
                reportedMap.put(r[1], list);
            }
        }
        
        int[] answer = new int[id_list.length];
        for(String key: reportedMap.keySet()) {
            if(reportedMap.get(key).size() >= k) {
                ArrayList<String> list = reportedMap.get(key);
                for(int i = 0; i < list.size(); i++) {
                    answer[reportedId.get(list.get(i))]++;
                }
            }
        }
        
        
        return answer;
    }
}