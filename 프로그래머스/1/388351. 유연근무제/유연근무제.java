class Solution {
    public final static int MINUTE = 60;
    public final static int WEEK = 7;
    public final static int SATURDAY = 6;
    public final static int SUNDAY = 7;
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        // 직원 수
        int n = schedules.length;
        
        // 직원들 출근 체크용 배열
        int[] employees = new int[n];
        
        // 출근으로 인정되는 시간 배열
        int[] deadLine = new int[n];
        for(int i = 0; i < n; i++) {
            deadLine[i] = timeConverter(schedules[i]);
        }
        
        for(int i = 0; i < WEEK; i++) {
            int today = startday + i <= WEEK ? startday + i : (startday + i) - WEEK;
            // 주말이면 패스
            if(isWeekend(today)) continue;
            // 평일에는 체크
            else {
                for(int j = 0; j < n; j++) {
                    if(timelogs[j][i] <= deadLine[j]) {
                        employees[j]++;
                    }
                    
                    if(employees[j] == (WEEK - 2)) answer++;
                }
                
            }
        }
        
        return answer;
    }
    
    public static boolean isWeekend(int day) {
        boolean result = false;
        if(day == SATURDAY || day == SUNDAY) 
            result = true;
        
        return result;
    }
    
    public static int timeConverter(int time) {
        time += 10;
        if(time % 100 >= MINUTE) {
            int tmp = (int)(time / 100) + 1;
            time = (tmp * 100) + (time % 100 - MINUTE);
        }
        
        return time;
    }
}