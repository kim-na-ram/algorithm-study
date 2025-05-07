import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        long min = 0;
        long max = 0;
        int[] cables = new int[K];
        for(int i = 0; i < K; i++) {
            cables[i] = sc.nextInt();
            max = Math.max(max, cables[i]);
        }
        
        max += 1;

        while(min < max) {
            long mid = (min + max) / 2;

            long count = 0;
            for(int cable : cables) {
                count += (cable / mid);
            }

            // count가 필요한 랜선의 개수(N)와 같거나 크다면
            // 최대 랜선의 길이를 구해야 하므로 min을 mid + 1로 변경
            if(count >= N) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        
        System.out.println(min - 1);
    }
}