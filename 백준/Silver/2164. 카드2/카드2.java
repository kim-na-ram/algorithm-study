import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
        
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}

		int take = 0;
		while(!q.isEmpty()) {
            take = q.poll();
			if(!q.isEmpty()) {
				q.offer(q.poll());
			}
		}

		System.out.print(take);
	}
}