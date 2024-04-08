import java.io.*;
import java.util.*;

public class BOJ_17086_아기_상어_2 {
    static int n, m, sea[][];
    static boolean visited[][];
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sea = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());

                // 상어가 있는 경우 큐에 집어넣음
                if (sea[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        System.out.println(BFS(n, m, q) - 1);
    }

    static int BFS(int n, int m, Queue<int[]> q) {
        visited = new boolean[n][m];
        int check = 2; // 떨어진 거리, 상어 위치(1)에서 한 칸 떨어진 것을 의미

        while (!q.isEmpty()) {
            // 상어의 위치를 하나 꺼냄
            int[] now = q.poll();

            // 좌상, 상, 우상, 우, 우하, 하, 좌하, 좌 순으로 8방향 탐색
            for (int i = 0; i < 8; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                // 전체 범위를 벗어나면 탐색 중지
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }
                // 상어가 있거나 이미 계산된 경우 탐색 중지
                if (sea[nextX][nextY] >= 1) {
                    continue;
                }

                visited[nextX][nextY] = true;
                sea[nextX][nextY] = sea[now[0]][now[1]] + 1; // 거리 +1

                // 갱신된 위치 추가, 재탐색
                q.add(new int[]{nextX, nextY});

                check = Math.max(sea[nextX][nextY], check);
            }
        }
        return check;
    }
}