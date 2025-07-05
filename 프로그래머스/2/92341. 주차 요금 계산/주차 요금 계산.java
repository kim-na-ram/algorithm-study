import java.util.*;

class Solution {
    static final long ms = 1000L;
    static final long min = 60 * 1000L;
    static final long hour = 60 * 60 * 1000L;
    static final long last = 23 * hour + 59 * min;
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<Long>> recordMap = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();
        
        for(int i = 0; i < records.length; i++) {
            String[] recordSplit = records[i].split(" ");
            String[] timeSplit = recordSplit[0].split(":");
            
            long time = (Long.parseLong(timeSplit[0]) * hour)
                            + (Long.parseLong(timeSplit[1]) * min);
            
            if(!recordMap.containsKey(recordSplit[1])) {
                recordMap.put(recordSplit[1], new ArrayList<Long>());
            }
            
            recordMap.get(recordSplit[1]).add(time);
        }
        
        recordMap.forEach((k, v) -> {
            int timeSum = 0;
            int lastIndex = v.size();
            
            if(v.size() % 2 != 0) {
                timeSum += last - v.get(v.size() - 1);
                lastIndex = v.size() - 1;
            }
            
            for(int i = 0; i < lastIndex; i++) {
                if(i % 2 == 0)
                    timeSum -= v.get(i);
                else
                    timeSum += v.get(i);
            }
            
            if(!feeMap.containsKey(k)) {
                feeMap.put(k, 0);
            }
            
            int carFee = calculateFee(fees, timeSum);
            System.out.println(k + " : " + timeSum + ", " + carFee);
            feeMap.put(k, feeMap.get(k) + carFee);
        });

        List<String> carNumbers = new ArrayList(feeMap.keySet());
        
        Collections.sort(carNumbers);
        
        int[] answer = new int[feeMap.size()];
        
        for(int i = 0; i < feeMap.size(); i++) {
            answer[i] = feeMap.get(carNumbers.get(i));
        }
        
        return answer;
    }
    
    public int calculateFee(int[] fees, long total) {
        long basicTime = fees[0] * min;
        int basicFee = fees[1];
        
        long unitTime = fees[2] * min;
        int unitFee = fees[3];
        
        int sum = basicFee;
        
        if(total > basicTime) {
            long restTime = total - basicTime;
            sum += Math.ceil((float)restTime / (float)unitTime) * unitFee;
        }
        
        return sum;
    }
}