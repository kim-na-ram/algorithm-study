import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String first = sc.nextLine();
        String second = sc.nextLine();

        int firstLength = first.length();
        int secondLength = second.length();
        
        int[][] lcs = new int[firstLength + 1][secondLength + 1];
        for(int i = 1; i < firstLength + 1; i++) {
            for(int j = 1; j < secondLength + 1; j++) {
                if(first.charAt(i - 1) == second.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        if(lcs[firstLength][secondLength] == 0) {
            System.out.print("0");
            return ;
        }

        StringBuilder sb = new StringBuilder();
        int rIdx = firstLength;
        int cIdx = secondLength;

        while(rIdx > 0 && cIdx > 0) {
            if(lcs[rIdx][cIdx] != lcs[rIdx - 1][cIdx] 
               && lcs[rIdx][cIdx] != lcs[rIdx][cIdx - 1]) {
                sb.append(first.charAt(rIdx - 1));
                rIdx--;
                cIdx--;
            } else if(lcs[rIdx][cIdx] != lcs[rIdx - 1][cIdx]) {
                cIdx--;
            } else {
                rIdx--;
            }
        }

        System.out.println(lcs[firstLength][secondLength]);
        System.out.print(sb.reverse());
    }
}