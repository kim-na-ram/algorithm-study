import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String first = sc.next();
        String second = sc.next();

        int max = 0;

        int[][] LCS = new int[first.length()][second.length()];
        for(int i = 0; i < first.length(); i++) {
            for(int j = 0; j < second.length(); j++) {
                if(first.charAt(i) == second.charAt(j)) {
                    if(i - 1 < 0 || j - 1 < 0) LCS[i][j] = 1;
                    else LCS[i][j] = LCS[i - 1][j - 1] + 1;

                    max = Math.max(max, LCS[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}