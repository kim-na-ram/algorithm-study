import java.io.*;
import java.util.*;

class Main {
    public static String[] players = {"CY", "SK"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int rest = N % 3;
        int winner = -1;

        if((N / 3) % 2 != 0) winner = 1;
        else winner = 0;
        
        while(rest --> 0) {
            if(winner == 0) winner = 1;
            else winner = 0;
        }

        System.out.println(players[winner]);
    }
}