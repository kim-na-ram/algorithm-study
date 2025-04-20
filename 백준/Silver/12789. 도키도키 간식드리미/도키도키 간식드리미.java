import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			
			queue.add(Integer.parseInt(st.nextToken()));
			
		}
        
        int start = 1;
		
		while(!queue.isEmpty()) {
			
			if(queue.peek() != 1) {
                
                if(!stack.isEmpty() && stack.peek() == start) {
                    stack.pop();
                    start++;
                } else {
                    stack.push(queue.poll());
                }
                
            } else {
                
                queue.poll();
                start++;
                
            }
				
		}
		
		while(!stack.isEmpty()) {
			
			if(stack.peek() != start) {
                
                System.out.println("Sad");
                return ;
                
            } else {
                
                stack.pop();
                start++;
                
            }
			
		}
		
		System.out.println("Nice");
		
	}

}