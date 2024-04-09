import java.io.*;
import java.util.*;

public class BOJ_21736_헌내기는_친구가_필요해 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        int dr = 0; // 헌내기 위치 저장
        int dc = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'I') {
                    dr = i;
                    dc = j;
                }
            }
        }
        DFS(dr, dc);

        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 'P') result++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 위치가 유효하고 방문한 적 없으며 벽이 아닌 경우
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                if (map[nx][ny] != 'X') {
                    DFS(nx, ny);
                }
            }
        }
    }
}