import java.io.*;
import java.util.*;

public class Main { // Boj_17086_아기 상어 2
    static int N, M, answer;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
    static boolean[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) {
                    continue;
                }
                arr[i][j] = true;
            }
        }
        answer = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!arr[i][j]) {
                    int max = bfs(i, j);
//                    System.out.println("현재 좌표 = " + i + "," + j  );
//                    System.out.println("max = " + max);
                    answer = Math.max(answer, max);
                }
            }
        }
        System.out.println(answer);
    }

    public static int bfs(int x, int y) {
        visit = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y, 0});
        visit[x][y] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int now_x = now[0];
            int now_y = now[1];
            int dist = now[2];

            for (int i = 0; i < 8; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if (range_chk(next_x, next_y) && !visit[next_x][next_y]) {
                    if (arr[next_x][next_y]) {
                        return dist + 1;
                    }
                    que.add(new int[]{next_x, next_y, dist + 1});
                    visit[next_x][next_y] = true;
                }
            }
        }
        return -1;
    }

    public static boolean range_chk(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < M;
    }
}