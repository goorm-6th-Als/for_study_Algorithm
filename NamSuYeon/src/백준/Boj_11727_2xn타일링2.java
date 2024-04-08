package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11727_2xn타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] DP = new int[1001];

        DP[1] = 1;
        DP[2] = 3;

        for(int i = 3; i<=n; i++){
            DP[i] = (DP[i-1]+ DP[i-2] *2 ) % 10007;
        }

        System.out.println(DP[n]);
    }
}
