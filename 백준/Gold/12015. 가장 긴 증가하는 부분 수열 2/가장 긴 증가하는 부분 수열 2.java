import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 증가하는 부분 수열을 저장할 배열
        int[] sequence = new int[N];
        // 증가하는 부분 수열 배열의 길이를 저장하는 변수
        int sequenceLength = 0;

        sequence[sequenceLength++] = A[0];

        // for문을 돌며, 배열을 채워넣음
        for(int i = 1; i < N; i++) {
            int high = sequenceLength - 1;

            if(A[i] > sequence[high]) {
                sequence[sequenceLength++] = A[i];
            } else {
                int low = 0;
                while(low < high) {
                    int mid = (low + high) / 2;

                    if(sequence[mid] < A[i]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }

                // sequence 배열의 low번 요소를 A[i]로 대치
                sequence[low] = A[i];
            }
        }

        System.out.println(sequenceLength);
    }
}