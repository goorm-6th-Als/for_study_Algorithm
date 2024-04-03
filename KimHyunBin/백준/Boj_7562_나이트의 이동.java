import java.io.*;
import java.util.*;


public class Main { //Boj_7562_나이트의 이동
    // 상하좌우
    static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int[] dy = {2, 2, 1, -1, -2, -2, -1, 1};
    static int Tc, l, x, y, target_x, target_y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Tc = Integer.parseInt(br.readLine());
        for (int T = 0; T < Tc; T++) {
            l = Integer.parseInt(br.readLine()); //
            int[][] arr = new int[l][l];
            boolean visit[][] = new boolean[l][l];
            // 체스판 크기
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            target_x = Integer.parseInt(st.nextToken());
            target_y = Integer.parseInt(st.nextToken());
            int answer = bfs(x, y, target_x, target_y, visit);
            System.out.println(answer);
        }
    }

    public static int bfs(int x, int y, int target_x, int target_y, boolean[][] visit) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y, 0});
        visit[x][y] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int now_x = now[0], now_y = now[1], dist = now[2];

            if (now_x == target_x && now_y == target_y) {
                return dist;
            }

            for (int i = 0; i < 8; i++) {
                int next_x = now_x + dx[i], next_y = now_y + dy[i];
                if (range_Chk(next_x, next_y) && !visit[next_x][next_y]) {
                    que.add(new int[]{next_x, next_y, dist + 1});
                    visit[next_x][next_y] = true;
                }
            }
        }
        return -1;
    }

        // 범위 체크
        public static boolean range_Chk ( int x, int y){
            return x >= 0 && y >= 0 && x < l && y < l;
        }
}