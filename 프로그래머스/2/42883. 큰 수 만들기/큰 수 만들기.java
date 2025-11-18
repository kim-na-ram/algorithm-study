class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int answerLen = number.length() - k;
        int pos = 0;
        
        while(pos < number.length() && sb.length() < answerLen) {
            int max = 0;
            int end = k + sb.length();
            
            for(int i = pos; i <= end; i++) {
                if(max < number.charAt(i) - '0') {
                    max = number.charAt(i) - '0';
                    pos = i + 1;
                }
            }
            
            sb.append(max);
        }
        
        return sb.toString();
    }
}