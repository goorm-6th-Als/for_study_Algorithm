import java.io.*;
import java.util.*;

public class Main { // Boj_1743_음식물 피하기
	public static int N, M, K, answer;
	public static int[] dr = { 1, -1, 0, 0 };
	public static int[] dc = { 0, 0, 1, -1 };
	public static boolean[][] visit, map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = true;
		}

		Queue<int[]> que = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] && !visit[i][j]) {
					int temp = 1;
					que.add(new int[] { i, j });
					visit[i][j] = true;
					while (!que.isEmpty()) {
						int[] now = que.poll();
						int now_r = now[0];
						int now_c = now[1];
						
						for (int k = 0; k < 4; k++) {
							int r = now_r + dr[k];
							int c = now_c + dc[k];
							if (!range(r, c))
								continue;
							if (!map[r][c])
								continue;
							if (visit[r][c])
								continue;
							que.add(new int[] { r, c });
							visit[r][c] = true;
							temp += 1;
						}
					}
					answer = Math.max(temp, answer);
				}
			}
		}

		System.out.println(answer);

	}

	public static boolean range(int r, int c) {
		return 1 <= r && 1 <= c && N >= r && M >= c;
	}
}
