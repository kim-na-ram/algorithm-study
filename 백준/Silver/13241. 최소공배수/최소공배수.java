import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] arr = br.readLine().split(" ");
        
        long a = Long.parseLong(arr[0]);
        long b = Long.parseLong(arr[1]);
        
        long lcm = a * b / gcm(a, b);
        
        System.out.println(lcm);
    }
    
    public static long gcm(long a, long b) {
        long tmp = 0;
        if(a < b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        
        if(b == 0) return a;
        return gcm(b, a % b);
    }
}