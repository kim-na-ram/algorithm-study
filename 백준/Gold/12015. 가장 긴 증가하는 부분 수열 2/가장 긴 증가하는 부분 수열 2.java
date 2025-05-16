import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 증가하는 부분 수열을 저장할 List
        List<Integer> sequence = new ArrayList<>();
        sequence.add(A[0]);

        // for문을 돌며, List를 채워넣음
        for(int i = 1; i < N; i++) {
            int high = sequence.size() - 1;

            if(A[i] > sequence.get(high)) {
                sequence.add(A[i]);
            } else {
                int low = 0;
                while(low < high) {
                    int mid = (low + high) / 2;

                    if(sequence.get(mid) < A[i]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                // List의 low번 요소를 A[i]로 대치
                sequence.set(low, A[i]);
            }
        }

        System.out.println(sequence.size());
    }
}