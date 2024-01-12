import java.util.*;
import java.io.*;

public class Main { // 2579_계단오르기
	// dp
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(br.readLine());
		int size = T;
		
		if (T <= 2) {
			size = 2;
		}
		
		int[] stair = new int[size + 1];
		int[] dp = new int[size + 1];
		// 계단은 1칸을 가거나, 2칸을 간다. 3연속은 불가능
		// dp[4] = 2 -> 4 또는 3 -> 4 존재 단 3 -> 4의 경우 1 3 만 가능.
		// dp[i] = Math.max(dp[i-2],dp[i-3]+stair[i-1]) + stair[i];
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			stair[i] = N;
		}

		dp[0] = 0;
		dp[1] = stair[1];
		dp[2] = stair[1] + stair[2];

		for (int i = 3; i <= T; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i];
		}

		System.out.println(dp[T]);
	}
}
