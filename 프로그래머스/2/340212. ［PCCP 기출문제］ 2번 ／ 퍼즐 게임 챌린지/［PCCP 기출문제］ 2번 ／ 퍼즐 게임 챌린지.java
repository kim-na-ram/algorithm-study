class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int lt = 1;
        int rt = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            rt = Math.max(rt, diffs[i]);
        }

        // 이분 탐색을 통해 조건에 맞는 숙련도를 찾음
        while (lt < rt) {
            int mid = (lt + rt) / 2;

            // 현재 숙련도에서 계산한 총 시간이 제한 시간을 넘어가면 숙련도를 올리고
            if (limit < calcTotalTime(diffs, times, mid)) {
                lt = mid + 1;
            } 
            // 제한 시간 내에 풀 수 있으면 레벨을 줄여가며 최소한의 레벨을 찾음
            else {
                rt = mid;
            }
        }
        
        return rt;
    }
    
    public long calcTotalTime(int[] diffs, int[] times, int mid) {
        long sum = times[0];
        for(int i = 1; i < diffs.length; i++) {
            int time_cur = times[i];
            int time_prev = times[i - 1];
            
            if(mid >= diffs[i]) {
                sum += time_cur;
            } else {
                sum += time_cur + ((time_cur + time_prev) * (diffs[i] - mid));
            }
        }
        
        return sum;
    }
}