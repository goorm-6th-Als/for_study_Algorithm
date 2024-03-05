import java.io.*;

public class BOJ_9657_돌_게임_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;

        for (int i = 5; i <= n; i++) {
            // 1개, 3개, 4개 돌을 가져왔는데 상대가 패배 상태이면 현재 플레이어가 승리 
            if (dp[i - 1] == 0 || dp[i - 3] == 0 || dp[i - 4] == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }

        if (dp[n] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
