import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String tmp = arr[i].toLowerCase();
            if(arr[i].length() == 0) sb.append(" ");
            else {
                if (Character.isAlphabetic(tmp.charAt(0))) {
                    sb.append(tmp.substring(0, 1).toUpperCase()).append(tmp.substring(1, tmp.length())).append(" ");
                } else sb.append(tmp).append(" ");
            }
        }
        
        if(s.substring(s.length() - 1, s.length()).equals(" ")) return sb.toString();
        else return sb.deleteCharAt(sb.length() - 1).toString();
    }
}