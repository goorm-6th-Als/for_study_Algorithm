package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_8394_악수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int personOfSize = Integer.parseInt(br.readLine());
        int[] DP = new int[personOfSize+1];

        DP[0] = 0;
        DP[1] = 1;

        for(int i = 2; i<=personOfSize; i++){
            if(i == 2){
                DP[2] = 2;
            }else{
                DP[i] = (DP[i - 1] + DP[i - 2])%10;
            }
        }

        System.out.println(DP[personOfSize]);
    }
}
