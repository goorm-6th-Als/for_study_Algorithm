import java.util.*;
import java.io.*;

public class Main { // Boj_2579_계단 오르기
	public static int N,answer;
	public static int[] dp, arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int size = N;
		if(size <3) {
			size = 3;
		}
		dp = new int[size+1];
		arr = new int[size+1];
		
		for(int t = 1; t<=N; t++) {
			arr[t] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = Math.max( dp[1] + arr[3], arr[2]+arr[3]);
		for(int i = 3; i<=N; i++) {
			dp[i] = Math.max(dp[i-2]+ arr[i], dp[i-3]+ arr[i-1] + arr[i]);
		}

		System.out.println(dp[N]);
	}
}