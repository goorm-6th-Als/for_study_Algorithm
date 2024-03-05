import java.util.*;
import java.io.*;

public class Main {// Boj_11637_인기 투표
	static int T, N, M;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) { // Tc
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			int candidate = 0;
			int max = -1;
			int sum = 0;
			int winner_cnt = 0;
			boolean winner = false;
			for (int j = 1; j <= N; j++) { // input
				st = new StringTokenizer(br.readLine());
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
			} // input

			for (int k = 1; k <= N; k++) {
				if (max < arr[k]) { // 최대값 갱신
					max = arr[k];
					candidate = k;
					winner = true;
				} else if (max == arr[k]) { // 동일값 등장 시
					winner = false;
				} else if (max > arr[k] && winner) { // max보다 작을 시
					winner = true;
				}
			}
			


			if (winner) {
				if (sum - max < max) {
					sb.append("majority winner " + candidate);
					sb.append("\n");
				} else {
					sb.append("minority winner " + candidate);
					sb.append("\n");
				}
			} else {
				sb.append("no winner");
				sb.append("\n");
			}
		} // Tc
		System.out.println(sb);
	}
}
