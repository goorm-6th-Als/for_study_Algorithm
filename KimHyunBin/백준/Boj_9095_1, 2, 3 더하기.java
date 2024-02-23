import java.io.*;
import java.util.*;

class Main { // Boj_9095_1, 2, 3 더하기
    public static int[] dp;
    public static int T, N;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            dp = new int[Math.max(N + 1, 4)];
            dp[1] = 1; // 1
            dp[2] = 2; // 1+1, 2
            dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}