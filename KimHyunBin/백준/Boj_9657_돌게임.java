import java.io.*;
import java.util.StringTokenizer;

public class Main {// Boj_9657_돌게임
    // DP
    public static int N;
    public static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        dp = new boolean[Math.max(N+1,4)];
        // 상근 먼저 시작, SK, CY
        dp[1] = true;
        dp[3] = true;
        dp[4] = true;

        // 상근이가 이긴 숫자에서 +1,+3,+4 라면 창연 승
        for(int i = 5; i<=N; i++){
            dp[i] = !dp[i - 1] || !dp[i - 3] || !dp[i - 4];
        }
        String s = dp[N] ? "SK" : "CY";
        System.out.println(s);
    }
}
