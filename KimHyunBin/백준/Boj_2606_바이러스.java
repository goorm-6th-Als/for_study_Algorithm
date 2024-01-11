import java.util.*;
import java.io.*;

public class Main {// Boj_1969_DNA
	static boolean map[][];
	static boolean visit[];
	static int N, M, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		map = new boolean[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}
		visit[1] = true;
		dfs(1);

		sb.append(answer);
		System.out.println(sb);
	}

	public static void dfs(int start) {
		for (int i = 1; i < N + 1; i++) {
			if (map[start][i]) {
				if (visit[i]) {
					continue;
				}
				visit[i] = true;
				answer++;
				dfs(i);
			}
		}
	}
}