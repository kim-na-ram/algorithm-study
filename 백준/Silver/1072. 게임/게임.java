import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = calculate(X, Y);

        if(Z >= 99) {
            System.out.println(-1);
            return ;
        }

        int low = 0;
        int high = X;

        while(low <= high) {
            int mid = (low + high) / 2;
            int newZ = calculate(X + mid, Y + mid);
            
            if(Z != newZ) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }

    public static int calculate(int X, int Y) {
        return (int) ((long) Y * 100 / X);
    }
}