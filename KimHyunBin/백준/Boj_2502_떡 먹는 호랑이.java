import java.io.*;
import java.util.StringTokenizer;

public class Main {// Boj_2502_떡 먹는 호랑이
    // DP 탑 다운?
    public static int D, K, A, B;
    public static int [][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        D = Integer.parseInt(st.nextToken()); // 날짜
        K = Integer.parseInt(st.nextToken()); // 떡 개수
        // 2 7 9 16 25 41 ...
        // dp[i], dp[i+1], (dp[i] + dp[i+1]),(dp[i+1]+ (dp[i] + dp[i+1]))
        //1A+1B	/1A+2B /2A+3B /3A+5B /5A+8B	/8A+11B	/13A+19B /21A+30B /34A+49B
        dp = new int [D+1][2]; // 0에는 A값, 1에는 B값.
        dp[1][0] = 1;
        dp[2][1] = 1;
        for(int i = 3; i<=D; i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        int A = dp[D][0];
        int B = dp[D][1];
        int sum = 0;
        for (int i = 1; i <= K; i++) {
            for (int j = i; j <= K; j++) {
                if (A*i + B*j == K) {
                    System.out.println(i + "\n" + j);
                    return; // 올바른 A와 B 값을 찾으면 반복 종료
                }
            }
        }
    }
}
