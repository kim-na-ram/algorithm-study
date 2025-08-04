import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stk = new Stack<>();
        int answer = 0;
        
        for(int i = 0; i < moves.length; i++) {
            int num = moves[i] - 1;
            for(int j = 0; j < board.length; j++) {
                if(board[j][num] > 0) {
                    if(!stk.isEmpty() && stk.peek() == board[j][num]) {
                        stk.pop();
                        answer += 2;
                    } else {
                        stk.push(board[j][num]);
                    }
                    board[j][num] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}