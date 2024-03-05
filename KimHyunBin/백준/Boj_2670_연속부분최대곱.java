import java.util.*;
import java.io.*;

public class Main {// Boj_2670_연속부분최대곱
	// dp로 해결, 2차월 배열로도 해결될듯.
	static double answer;
	static double arr[], dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		arr = new double[N];
		dp = new double[N];
		answer = -1;
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		// 풀이 1. DP
		dp[0] = arr[0];
		
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(arr[i], dp[i - 1] * arr[i]);
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.print(String.format("%.3f",answer));
//		answer = Math.round(answer * 10000.0) / 10000.0;
//		System.out.println(answer);

//		// 풀이 2. 브루트포스
//		for (int j = 0; j < N; j++) {
//			double temp = 1;
//			for (int i = j; i < N; i++) {
//				temp *= arr[i];
//				answer = Math.max(answer, temp);
//			}
//		}
//		// 이건 왜 안되는거지..??
////		answer = Math.round(answer * 10000.0) / 10000.0;
////		System.out.println(answer);
//		System.out.print(String.format("%.3f",answer));

	}
}