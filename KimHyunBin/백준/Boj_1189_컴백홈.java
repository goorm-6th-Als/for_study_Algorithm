import java.io.*;
import java.util.*;

public class Main { // Boj_1189_컴백홈
	public static int R, C, K, answer, min;
	public static char[][] map;
	public static boolean[][] visit;
	public static int[] dr = { 1, -1, 0, 0 };
	public static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		map = new char[R][C];
		visit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '.') {
				}
			}
		}

//		min = bfs(R - 1, 0);
//		visit = new boolean[R][C];
		visit[R - 1][0] = true;
		dfs(R - 1, 0, 1);

		System.out.println(answer);
	}

	public static void dfs(int r, int c, int depth) {
		if (depth > K) {
			return;
		}
		if (r == 0 && c == C - 1 && depth == K) {
			answer++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int row = r + dr[i];
			int col = c + dc[i];
			if (chk(row, col)) {
//				System.out.println("dfs");
				visit[row][col] = true;
				dfs(row, col, depth + 1);
				visit[row][col] = false;
			}
		}
	}

//	public static int bfs(int r, int c) {
//
//		int cnt = 0;
//		Queue<int[]> que = new LinkedList<>();
//		que.add(new int[] { r, c });
//		visit[r][c] = true;
//		while (!que.isEmpty()) {
//			int[] now = que.poll();
//			int now_row = now[0];
//			int now_col = now[1];
//			if (now_row == 0 && now_col == C - 1) {
//				return cnt;
//			}
//			for (int i = 0; i < 4; i++) {
//				int row = now_row + dr[i];
//				int col = now_col + dc[i];
//				if (chk(row, col)) {
//					que.add(new int[] { row, col });
//					visit[row][col] = true;
//					cnt++;
//				}
//			}
//		}
//		return -1;
//	}

	public static boolean chk(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C && map[r][c] != 'T' && !visit[r][c];
	}
}