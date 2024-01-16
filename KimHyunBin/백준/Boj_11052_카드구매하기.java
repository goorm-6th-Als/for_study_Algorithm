import java.util.*;
import java.io.*;

public class Main {// Boj_11052_카드구매하기
	// DP 해결, 그리디
	static int N, answer;
	static int[] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		dp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 0;
		dp[1] = arr[1];
		// 가장 작은 단위의 카드부터 구매하면 된다.
		// 너무 어렵게 접근했네 ㅠㅠ
		// dp[2] = Math.max(dp[2],arr[2]);
		for (int i = 1; i <= N; i++) {
			for(int j = 1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
			}
		}
		System.out.println(dp[N]);

	}
}