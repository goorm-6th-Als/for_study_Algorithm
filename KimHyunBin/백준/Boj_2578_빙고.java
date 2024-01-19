import java.util.*;
import java.io.*;

public class Main {// Boj_2578_빙고

	static int N, answer;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int size = 5;
		map = new int[size][size];
		visited = new boolean[size][size];
		answer = 0;

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		loop: for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				answer += 1;
				int next = Integer.parseInt(st.nextToken());
				// logic
				for (int k = 0; k < size; k++) {
					for (int h = 0; h < size; h++) {
						if (next == map[k][h]) {
							visited[k][h] = true;
						}
					}
				}
				// 빙고 수
				int bingo = 0;
				int cnt;
				// 가로 체크
				for (int k = 0; k < size; k++) {
					cnt = 0;
					for (int h = 0; h < size; h++) {
						if (visited[k][h]) {
							cnt += 1;
						}

						if (cnt == 5) {
							bingo += 1;
						}
					}
				}
				// 세로 체크
				for (int k = 0; k < size; k++) {
					cnt = 0;
					for (int h = 0; h < size; h++) {
						if (visited[h][k]) {
							cnt += 1;
						}

						if (cnt == 5) {
							bingo += 1;
						}
					}
				}
				// 대각 왼쪽 아래방향 - 행과 열 idx 비율이 같음
				cnt = 0;
				for (int k = 0; k < size; k++) {
				    if (visited[k][k]) {
				        cnt += 1;
				    }
				}
				if (cnt == size) {
				    bingo += 1;
				}
				// 대각 오른쪽 위 방향 - 최대 행 + 열 = 최대 idx
				cnt = 0;
				for (int k = 0; k < size; k++) {
				    if (visited[k][size - 1 - k]) {
				        cnt += 1;
				    }
				}
				if (cnt == size) {
				    bingo += 1;
				}

				if (bingo >= 3) {
					break loop;
				}
			}
		}
		for (int k = 0; k < size; k++) {
			System.out.println();
			for (int h = 0; h < size; h++) {
				System.out.print(visited[k][h] + " ");
			}
		}
		System.out.println(answer);

	}
}