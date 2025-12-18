import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(T --> 0) {
            int days = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] stocks = new int[days];
            
            for(int i = 0; i < days; i++) {
                stocks[i] = Integer.parseInt(st.nextToken());
            }

            int max = stocks[days - 1];
            long buy = 0;
            for(int i = days - 2; i >= 0; i--) {
                if(max < stocks[i]) max = stocks[i];
                else {
                    buy += (max - stocks[i]);
                }
            }

            sb.append(buy).append("\n");
        }

        System.out.print(sb);
    }
}