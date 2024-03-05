import java.io.*;

public class BOJ_8394_악수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 피보나치 수열 Dp[n] = Dp[n-1] + Dp[n-2]
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 1; // 0명일 때 악수 불가
        dp[1] = 1; // 1명일 때 악수 불가

        for (int i = 2; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % 10);
        }
        System.out.println(dp[n]);

    }
}
