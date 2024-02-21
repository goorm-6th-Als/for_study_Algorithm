import java.io.*;
import java.util.*;

class Main { // Boj_10844_쉬운 계단 수
    public static long[][] dp;
    public static int N, answer;

    //이차원 배열로 구성해서 길이와, 시작 점
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[101][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        answer = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }

                dp[i][j] %= 1000000000;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
            sum %= 1000000000;
        }
        System.out.println(sum);
    }
}