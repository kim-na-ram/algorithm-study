import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> dataDictionary = new HashMap<>();
        
        dataDictionary.put("code", 0);
        dataDictionary.put("date", 1);
        dataDictionary.put("maximum", 2);
        dataDictionary.put("remain", 3);
        
        ArrayList<int[]> filterList = new ArrayList<>();
        
        for(int i = 0; i < data.length; i++) {
            int idx = dataDictionary.get(ext);
            if(data[i][idx] < val_ext) {
                filterList.add(data[i]);
            }
        }
        
        Collections.sort(filterList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int idx = dataDictionary.get(sort_by);
                return o1[idx] - o2[idx];
            }
        });
        
        int[][] answer = new int[filterList.size()][4];
        for(int i = 0; i < filterList.size(); i++) {
            answer[i] = filterList.get(i);
        }
        
        return answer;
    }
}