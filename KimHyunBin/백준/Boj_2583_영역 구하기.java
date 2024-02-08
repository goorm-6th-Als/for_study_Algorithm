import java.io.*;
import java.util.*;

public class Main { // Boj_2583_영역 구하기
	public static int N, M, K, cnt;
	public static int[][] map;
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];

		for (int input = 0; input < K; input++) {
			st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			for (int i = start_y; i < end_y; i++) {
				for (int j = start_x; j < end_x; j++) {
					map[i][j] = 1;
				}
			}
		}
		List<Integer> area = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					continue;
				cnt = 0;
				dfs(i, j);
				area.add(cnt);
			}
		}
		Collections.sort(area);
		sb.append(area.size() + "\n");
		for(int temp : area) {
			sb.append(temp + " ");
		}

		System.out.println(sb);
	}

	public static void dfs(int x, int y) {
		map[x][y] = 1;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];
			if(range(next_x,next_y)) {
				dfs(next_x,next_y);
			}
		}
	}

	public static boolean range(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N && map[x][y] != 1;
	}
}