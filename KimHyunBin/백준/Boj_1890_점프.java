import java.io.*;
import java.util.*;

public class Main { // Boj_1890_점프
    static int N, answer;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        dp = new long[N][N];
        dp[0][0] = 1;
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int now = arr[i][j];
                if (i == N - 1 && j == N - 1) {
                    continue;
                }

                if (i + now < N) {// 아래
                    dp[i + now][j] += dp[i][j];
                }
                if (j + now < N) {// 오른쪽
                    dp[i][j + now] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}