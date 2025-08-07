class Solution {
    public int solution(int number, int limit, int power) {
        prime = new int[number + 1];
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            checkDivisors(i);
            
            if(prime[i] > limit) answer += power;
            else answer += prime[i];
        }
        
        return answer;
    }
    
    public int[] prime;
    public void checkDivisors(int n) {
        for(int i = 1; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) {
                prime[n]++;
                if(i != n / i) prime[n]++;
            } 
        }
    }
}