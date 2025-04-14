import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Queue {
    
    private int front;
    private int rear;
    private int max;
    private int num;
    private int[] queue;
    
    public Queue(int max) {
        
        front = rear = num = 0;
        this.max = max;
        
        queue = new int[max];
        
    }
    
    public void push(int x) {
        
        if(num < max) {
        
            queue[rear++] = x;
            num++;
            
            if(rear == max) {
                
                rear = 0;
                
            }
        
        }
        
    }
    
    public int pop() {
        
        if(num <= 0) {
            
            return -1;
            
        }
        
        int x = queue[front++];
        num--;
        
        if(front == max) {
            front = 0;
        }
        
        return x;
        
    }
    
    public int size() {
        
        return num;
        
    }
    
    public int empty() {
        
        if(num <= 0) return 1;
        else return 0;
        
    }
    
    public int front() {
        
        if(num > 0) return queue[front];
        else return -1;
        
    }
    
    public int back() {
        
        if(num > 0) return queue[rear - 1];
        else return -1;
        
    }
    
}

public class Main {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    Queue que = new Queue(N);
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i = 0; i < N; i++) {
	        
	        String command = br.readLine();
	        
	        if(command.contains("push")) {
	            que.push(Integer.parseInt(command.split(" ")[1]));
	        } else if(command.contains("pop")) {
	            sb.append(que.pop()).append("\n");
	        } else if(command.contains("front")) {
	            sb.append(que.front()).append("\n");
	        } else if(command.contains("back")) {
	            sb.append(que.back()).append("\n");
	        } else if(command.contains("size")) {
	            sb.append(que.size()).append("\n");
	        } else if(command.contains("empty")) {
	            sb.append(que.empty()).append("\n");
	        }
	        
	    }
	    
	    System.out.println(sb);
	    
	}
}