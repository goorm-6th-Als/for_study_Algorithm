import java.io.*;
import java.util.StringTokenizer;

public class Main {// Boj_2156_포도주 시식
    // DP
    public static int N;
    public static int[] dp, arr;
    // 잔 마시고 제 위치.
    // 3잔 연속 불가능
    // 최대한 많은 양이 많게

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new int[Math.max(3, N + 1)];
        arr = new int[Math.max(3, N + 1)];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 이전 와인을 마시는게 이득인지 구분
        // 이전 와인을 마시면 dp i-3 을 사용해야함
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        // dp[i] = dp[i-1] 이랑 dp[i-2] + arr[i], dp[i-3] + arr[i] + arr[i-1]
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i] + arr[i - 1]));
        }
        System.out.println(dp[N]);

    }
}
