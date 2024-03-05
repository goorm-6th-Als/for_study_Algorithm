import java.io.*;
import java.util.StringTokenizer;

public class Main {// Boj_2502_떡 먹는 호랑이
    // DP 탑 다운?
    public static int D, K, A, B;
    public static int [] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int [31];

        // 상근이가 이긴 숫자에서 +1,+3,+4 라면 창연 승
        for(int i = 5; i<=N; i++){
            dp[i] = !dp[i - 1] || !dp[i - 3] || !dp[i - 4];
        }
        String s = dp[N] ? "SK" : "CY";
        System.out.println(s);
    }
}
