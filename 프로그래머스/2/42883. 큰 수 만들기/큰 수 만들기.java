class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int lenAnswer = number.length() - k;
        int startIndex = 0;

        while (startIndex < number.length() && sb.length() != lenAnswer) {
            int endNum = k + sb.length();
            int maxNum = 0;
            
            for (int i = startIndex; i <= endNum; i++) {
                if (maxNum < number.charAt(i) - '0') { 
                    maxNum = number.charAt(i) - '0';
                    // 가장 큰 값 찾았으면 그 수 뒤에거부터 다시 돌기
                    startIndex = i + 1;
                }
            }
            sb.append(Integer.toString(maxNum));
        }
        return sb.toString();
    }
}