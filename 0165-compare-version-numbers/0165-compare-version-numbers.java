import java.util.*;

class Solution {
    public int compareVersion(String version1, String version2) {
        StringTokenizer st1 = new StringTokenizer(version1, ".");
        StringTokenizer st2 = new StringTokenizer(version2, ".");
        
        int answer = 0;
        while(st1.hasMoreTokens() || st2.hasMoreTokens()) {
            int v1 = 0, v2 = 0;
            if(st1.hasMoreTokens()) v1 = Integer.parseInt(st1.nextToken());
            if(st2.hasMoreTokens()) v2 = Integer.parseInt(st2.nextToken());

            if(v1 > v2 || v1 < v2) {
                answer = v1 > v2 ? 1 : -1;
                break;
            }
        }

        return answer;
    }
}