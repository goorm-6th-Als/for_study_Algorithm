import java.util.*;
import java.io.*;

public class Main { // 10870_피보나치수5
	// dp
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int size = N;
		if(N <= 2) {
			size = 2;
		}
		int dp[] = new int[size + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		System.out.println(dp[N]);
	}
}
