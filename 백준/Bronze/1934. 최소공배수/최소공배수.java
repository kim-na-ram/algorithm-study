import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < tc; i++) {
            String[] numArr = br.readLine().split(" ");
            int a = Integer.parseInt(numArr[0]);
            int b = Integer.parseInt(numArr[1]);
            
            int lcm = a * b / gcm(a, b);
            sb.append(lcm).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static int gcm(int a, int b) {
        int tmp = 0;
        if(a < b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        
        if(a % b == 0) {
            return b;
        }
        
        return gcm(b, a % b);
    }
}