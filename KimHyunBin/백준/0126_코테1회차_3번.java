import java.util.*;
import java.io.*;

public class Main { // Boj_19949_영재의 시험
	public static int N, answer;
	public static int[] dp, arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 10;
		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, 0, 0, 0);

		System.out.println(answer);
	}

	// 이전번호랑 다를때만.
	public static void dfs(int depth, int cnt, int pre_num, int pre_cnt) {
		if (pre_cnt >= 2) {
			return;
		}
		if (depth == 11) {
			if (cnt >= 5) {
				answer++;
			}
			return;
		}
		
		// 찍는 번호 로직
		for (int i = 1; i <= 5; i++) {
			// 정답
			if (arr[depth] == i) {
				if (pre_num == i) { // 이전 번호 체크
					dfs(depth + 1, cnt + 1, i, pre_cnt + 1);
				} else {
					dfs(depth + 1, cnt + 1, i, 0);
				}
			}
			// 오답
			else {
				if (pre_num == i) { // 이전 번호 체크
					dfs(depth + 1, cnt, i, pre_cnt + 1);
				} else {
					dfs(depth + 1, cnt, i, 0);
				}
			}
		}
	}
}