import java.io.*;
import java.util.*;

class Main {
    public static final int OPERATOR_NUMBERS = 4;
    
    // 숫자 배열
    public static int[] numbers;
    // 연산자 배열
    public static int[] operators;

    // 최대, 최소
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        operators = new int[OPERATOR_NUMBERS];
        for(int i = 0; i < OPERATOR_NUMBERS; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);
        
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int result, int index) {
        if(index == numbers.length) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            
            return;
        }

        for(int i = 0; i < OPERATOR_NUMBERS; i++) {
            if(operators[i] > 0) {
                operators[i]--;

                switch(i) {
                    case 0:
                        dfs(result + numbers[index], index + 1);
                        break;
                    case 1:
                        dfs(result - numbers[index], index + 1);
                        break;
                    case 2:
                        dfs(result * numbers[index], index + 1);
                        break;
                    case 3:
                        dfs(result / numbers[index], index + 1);
                        break;
                }
                operators[i]++;
            }
        
        }
    }
}