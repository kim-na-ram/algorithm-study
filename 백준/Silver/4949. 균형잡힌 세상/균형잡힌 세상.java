import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(true) {
	        
	        String sentence = br.readLine();
	        char end = sentence.charAt(0);
	        
	        if(end == '.') {
	            System.out.println(sb);
	            break;
	        }
	        
	        sb.append(balenced_world(sentence)).append("\n");
	        
	    }
	    
	}
	
	public static String balenced_world(String s) {
        
        Stack<Character> bracket = new Stack<Character>();
	    
        for(int i = 0; i < s.length(); i++) {
	            
            char ch = s.charAt(i);
	            
            if(ch == '(' || ch == '[') bracket.push(ch);
	            
            else if (ch == ')') {
                if(bracket.empty() || bracket.peek() != '(') {
                    return "no";
                } else {
                    bracket.pop();
                }
            }
	            
            else if (ch == ']') {
	                
                if(bracket.empty() || bracket.peek() != '[') {
                    return "no";
                } else {
                    bracket.pop();
                }
	                
            }
        }
	        
        if(bracket.empty()) return "yes";
        else return "no";
	    
	}
	
}