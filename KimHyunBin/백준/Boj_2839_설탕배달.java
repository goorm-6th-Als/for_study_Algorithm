import java.io.*;
import java.util.*;

class Main { // Boj_2839_설탕배달
    public static int[] dp;
    public static int N, answer;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[5001];
        dp[3] = 1;
        dp[5] = 1;
        for (int i = 6; i <= N; i++) {
            if (dp[i - 3] == 0 && dp[i - 5] == 0) {
                continue;
            }
            if (dp[i - 5] == 0) {
                dp[i] = dp[i - 3] + 1;
            } else if (dp[i - 3] == 0) {
                dp[i] = dp[i - 5] + 1;
            } else {
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            }

        }

        answer = dp[N] == 0 ? -1 : dp[N];
        System.out.println(answer);
    }
}