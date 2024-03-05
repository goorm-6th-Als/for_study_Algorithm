import java.io.*;
import java.util.*;

class Main { // Boj_11727_2×n 타일링 2
    // 규칙찾자 규칙찾자 찎찎찎
    // 홀수 -> 짝수 앞뒤 중복되는경우 제외.
    // cnt 가 5였다면  만큼 증가.
    // cnt = (cnt*2)+ 1
    // 짝수 -> 홀수라면
    // cnt = (cnt * 2) -1
    public static int N, answer;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        answer = 0;
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            if(i % 2 == 1){ // 짝수번째
                dp[i] = (dp[i-1] * 2 - 1) % 10007;
            }else{  // 홀수번째
                dp[i] = (dp[i-1] * 2 + 1 )% 10007;
            }
        }

        System.out.print(dp[N] );
    }
}