import java.io.*;
import java.util.*;

public class Main { // Boj_14940_쉬운 최단거리
    static int N, M, start_r, start_c;
    static int[][] arr, answer;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        answer = new int[N][M]; // 오타 있었네.. N -> M
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    start_r = i;
                    start_c = j;
                }
            }
        }

        // 0 처리.. 집중합시다
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                answer[i][j] = -1;
            }
        }
        bfs(start_r, start_c);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r, c, 0});
        visited[r][c] = true;
        answer[r][c] = 0;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int dist = now[2];
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (range_chk(nr, nc) && arr[nr][nc] != 0 &&!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    answer[nr][nc] = dist + 1;
                    que.add(new int[]{nr, nc, dist + 1});
                }
            }
        }
    }

    public static boolean range_chk(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}