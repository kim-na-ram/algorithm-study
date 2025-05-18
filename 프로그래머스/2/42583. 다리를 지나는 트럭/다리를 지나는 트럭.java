import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Truck {
	int w;
	int t;
	
	public Truck(int w, int t) {
		this.w = w;
		this.t = t;
	}
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        ArrayList<Integer> arrived = new ArrayList<Integer>();
		
		Queue<Truck> bridge = new LinkedList<>();
        
        int answer = 0;
		
        int index = 0;
		int bridgeSum = 0;
		
		while(arrived.size() < truck_weights.length) {
			
			if(!bridge.isEmpty()) {
				if(answer == bridge.peek().t + bridge_length) {
					bridgeSum -= bridge.peek().w;
					arrived.add(bridge.poll().w);
				}
			}
			
			if(index < truck_weights.length) {
				if(bridgeSum + truck_weights[index] <= weight) {
					bridgeSum += truck_weights[index];
					bridge.offer(new Truck(truck_weights[index++], answer));
				}
			}
			
			answer++;
			
		}
        
        return answer;
    }
}