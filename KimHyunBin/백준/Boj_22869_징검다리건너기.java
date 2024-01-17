import java.util.*;
import java.io.*;

public class Main {// Boj_22869_징검다리건너기(small)
	// DP
	static int N, K; 
	static String answer;
	static int[] arr;
	static boolean [] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// K >= (j-i) * 1 + Math.abs(arr[i]-arr[j)
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		dp = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[1] = true;
		dp[2] = (arr[2]-arr[1] <= K) ? true : false;
		// 이동할수 있는 돌을 표시, 해당 돌들로 모든 연산 해보기.

		for (int i = 3; i <= N; i++) {
			
			for(int j = 1; j<=i; j++) {
				if(dp[j]) {
					System.out.print(i+"도착 "+j+"출발 ");
					if((i-j) * (1 + Math.abs(arr[i]-arr[j])) <= K) {
						dp[i] = true;
						System.out.print("가능");
						System.out.println();
					}else {
						System.out.print("불가능");
						System.out.println();
					}
				}
			}
		}
		answer = dp[N] ? "YES" : "NO";
		System.out.println(answer);

	}
}