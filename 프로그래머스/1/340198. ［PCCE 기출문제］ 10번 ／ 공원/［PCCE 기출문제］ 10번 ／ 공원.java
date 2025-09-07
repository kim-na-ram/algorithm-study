import java.util.*;

class Solution {
    public static int r, c;
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int answer = -1;
        
        for(int m = mats.length - 1; m >= 0; m--) {
            int mat = mats[m];
            for(int i = 0; i < park.length - mat + 1;i++) {
                for(int j = 0; j < park[i].length - mat + 1; j++) {
                    int sum = 0;
                    for(int n = i; n < i + mat; n++) {
                        for(int k = j; k < j + mat; k++) {
                            if(park[n][k].equals("-1")) sum++;
                            else sum = 0;
                            
                            if(sum == (mat * mat)) {
                                return mat;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}