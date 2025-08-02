class Solution {
    public int[] solution(String s) {
        int operCount = 0;
        int zeroCount = 0;
        
        while(!s.equals("1")) {
            zeroCount += s.length() - s.replaceAll("0", "").length();
            
            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
            
            operCount++;
        }
        
        int[] answer = {operCount, zeroCount};
        return answer;
    }
}