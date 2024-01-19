import java.util.*;
import java.io.*;

public class Main {// Boj_22869_징검다리 건너기 (small)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String answer = "";

		int[] arr = new int[N];
		boolean[] dp = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// (j-i) * (1+Math.abs(arr[i]-arr[j])

		dp[0] = true;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (dp[j]) {
					int power = (i-j) * ((1 + Math.abs(arr[i] - arr[j])));
					if (K >= power) {
						dp[i] = true;
					}
				}
			}
		}
		answer = dp[N-1] ? "YES" : "NO";
		System.out.println(answer);
	}
}
