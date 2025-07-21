import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] temp = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++)
            temp[i] = (Integer.toString(numbers[i]));
        
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return ((b+a).compareTo(a+b));
            }
        });
        
        if(temp[0].equals("0")) return "0";
        
        for(String a : temp) {
            answer += a;
        }
        
        return answer;
        
    }
}