import java.util.*;
import java.io.*;

class Main {
    public static List<Integer> lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] ab = new int[n][2];

        lis = new ArrayList<Integer>();

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ab[i][0] = a;
            ab[i][1] = b;
        }

        Arrays.sort(ab, (o1, o2) -> o1[0] - o2[0]);

        lis.add(ab[0][1]);
        for(int i = 1; i < n; i++) {
            if(lis.get(lis.size() - 1) < ab[i][1]) {
                lis.add(ab[i][1]);
            } else {
                search(ab[i][1]);
            }
        }

        System.out.println(n - lis.size());
    }

    public static void search(int target) {
        int min = 0;
        int max = lis.size() - 1;

        while(min <= max) {
            int mid = (min + max) / 2;

            if(lis.get(mid) < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        lis.set(min, target);
    }
}