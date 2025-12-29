import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        boolean isNotZero = false;
        st = new StringTokenizer(br.readLine());
        
        int[] visitors = new int[N];
        for(int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
            
            if(visitors[i] != 0)
                isNotZero = true;
        }
        
        if(!isNotZero) {
            System.out.print("SAD");
            return ;
        }
        
        int first = 0, last = X, sum = 0;
        for(int i = first; i < last; i++) { 
            sum += visitors[i];
        }
        
        int max = sum;
        int count = 1;
       
        while(first <= N - X && last < N) {
            sum = sum - visitors[first++];
            sum = sum + visitors[last++];
            
            if(max == sum) count++;
            else if (sum > max) {
                max = sum;
                count = 1;
            }
        }

        System.out.println(max);
        System.out.print(count);
    }
}