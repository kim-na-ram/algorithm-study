import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        
        double low = 0.0;
        double high = (double) Math.min(L, Math.min(W, H));
        
        while(low <= high) {
            double mid = (low + high) / 2.0;

            if((long)(L / mid)*(long)(W / mid)*(long)(H / mid) >= N) {
                if(low == mid) break;
                low = mid;
            } else {
                if(high == mid) break;
                high = mid;
            }
        }
        
        System.out.println(low);
    }
}