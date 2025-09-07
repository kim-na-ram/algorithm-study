class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        String s = Integer.toString(storey);
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        
        for(int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            
            // 만약 올라가는게 더 빠르다면
            if(num >= 6) {
                answer += 10 - num;
                
                if(i > 0) {
                    arr[i - 1]++;
                } else {
                    answer++;
                    break;
                }
            }
            // 내려가는게 더 빠르다면
            else if(num <= 4) {
                answer += num;
            }
            // num이 5일 때
            else {
                if(i > 0) {
                    if(arr[i - 1] >= 5) { // 올리는게 최소
                        answer += 5;
                        arr[i - 1]++;
                    }
                    else { // 내리는게 최소
                        answer += 5;
                    }
                } else {
                    answer += 5;
                    break;
                }
            }
        }
        
        return answer;
    }
}

