class Solution {
    public int solution(int n, int w, int num) {
        int row = n % w == 0 ? n / w : (n / w) + 1;
        int col = w;
        
        // 0 -> 1 ~ n*1
        // 1 -> n*2 ~ n+1
        // 2 -> (n*2)+1 ~ (n*3)
        // 3 -> (n*3)+1 ~ (n*4)
        
        int targetRow = num % w == 0 ? (num / w) - 1 : num / w;
        int targetCol = 0;
        
        // 해당 박스가 있는 행이 짝수라면 왼쪽부터
        if(targetRow % 2 == 0) {
            targetCol = num - targetRow * col - 1;
        } else {
            targetCol = (col * (targetRow + 1)) - num;
        }
        
        int answer = (row - 1) - targetRow;
        System.out.println((row - 1) + " - " + targetRow);
        // 만약 마지막 행이 짝수라면 오른쪽부터
        if(row % 2 == 0) {
            int lastCol = (col * row) - n;
            if(lastCol <= targetCol) {
                answer++;
            }
        }
        // 마지막 행이 홀수라면 왼쪽부터
        else {
            int lastCol = n - ((row - 1) * col) - 1;
            if(lastCol >= targetCol) {
                answer++;
            }
        }
        
        return answer;
    }
}