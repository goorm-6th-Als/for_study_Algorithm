import java.util.*;
import java.io.*;

public class Main {
	private static int N = 10;
	static int[] arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		answer = 0;
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0, 0, 0);
		System.out.println(answer);
	}

	private static void dfs(int depth, int last_num, int cnt, int last_cnt) {
		if (last_cnt == 2) { // 연속적으로 같은번호 3개는 불가능.
			return;
		}
		
		if (depth == N) {
			if (cnt >= 5) {
				answer += 1; // 정답이 5개 이상인 경우.
			}
			return;
		}

		for (int i = 1; i <= 5; i++) {
			if (i == last_num) { // 이전번호와 같게 찍었다면
				if (i == arr[depth]) { // 정답
					dfs(depth + 1, i, cnt + 1, last_cnt + 1);
				} else {
					dfs(depth + 1, i, cnt, last_cnt + 1);
				}
			} else { // 이전번호와 달랐다면.
				if (i == arr[depth]) { // 정답
					dfs(depth + 1, i, cnt + 1, 0);
				} else {
					dfs(depth + 1, i, cnt, 0);
				}
			}
		}
	}
}