import java.io.*;

public class 코테2회차_2번 { // BOJ_2579_계단_오르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] stair = new int[n + 1]; 
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            dp[1] = stair[1];
        } else if (n == 2) {
            dp[2] = stair[2] + stair[1];
        } else {
            dp[1] = stair[1];
            dp[2] = stair[2] + stair[1];
            dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);

            for (int i = 4; i < n + 1; i++) {
                
                // (두 계단 + 한 계단 오른 경우, 한 번에 두 계단 오른 경우)
                dp[i] = Math.max(dp[i - 3] + stair[i - 1] + stair[i], dp[i - 2] + stair[i]);
            }
        }
        System.out.println(dp[n]);

    }
}
