class Solution {
    public static long tenSecond = 10 * 1000;
    public static long videoLength, openingStart, openingEnd;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        long position = convertToLongTime(pos);
        videoLength = convertToLongTime(video_len);
        openingStart = convertToLongTime(op_start);
        openingEnd = convertToLongTime(op_end);
        
        position = checkOpeningSection(position);
        
        for(String command : commands) {
            position = moveToTenSecond(command, position);
        }
        
        long minute = position / (60 * 1000);
        long second = (position - (minute * 60 * 1000)) / 1000;
        
        String answer = String.format("%02d:%02d", minute, second);
        return answer;
    }
    
    // string으로 들어오는 시간들을 long형으로 변환하는 메서드
    public static long convertToLongTime(String time) {
        int min = Integer.parseInt(time.split(":")[0]);
        int sec = Integer.parseInt(time.split(":")[1]);
        
        long minute = min * 60 * 1000;
        long second = sec * 1000;
        
        return minute + second;
    }
    
    // 오프닝 구간일 경우, 오프닝이 끝나는 위치로 이동시키는 메서드
    public static long checkOpeningSection(long position) {
        boolean isOpeningSection = false;
        
        if(openingStart <= position && openingEnd >= position)
            isOpeningSection = true;
        
        return isOpeningSection ? openingEnd : position;
    }
    
    // command에 따라 앞, 뒤로 10초 이동시키는 메서드
    public static long moveToTenSecond(String command, long position) {
        long nxtPosition = 0;
        switch(command) {
            case "next":
                if(position + tenSecond > videoLength)
                    nxtPosition = videoLength;
                else nxtPosition = position + tenSecond;
                break;
            case "prev" :
                if(position - tenSecond < 0)
                    nxtPosition = 0;
                else nxtPosition = position - tenSecond;
                break;
        }
        
        return checkOpeningSection(nxtPosition);
    }

}