class Solution {
    public int[] solution(int brown, int yellow) {
        int w = 0, h = 0;
        
        for(int i = yellow; i >= (int)Math.sqrt(yellow); i--) {
            if(yellow % i == 0) {
                w = i + 2;
                h = (yellow / i) + 2;
                int size = (w * 2) + (h * 2) - 4;
                
                if(size == brown) break;
            }
        }
        
        int[] answer = {w, h};
        return answer;
    }
}