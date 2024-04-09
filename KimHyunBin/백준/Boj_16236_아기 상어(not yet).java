import java.io.*;
import java.util.*;

public class Main { // Boj_16236_아기 상어
    static class Node {
        private int x;
        private int y;
        private int dist;
        private Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int N, M, answer, start_x, start_y, shark_Size, time;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9){
                    start_x = i;
                    start_y = j;
                }
            }
        }
        shark_Size = 1;
        time = 0;
        bfs(start_x,start_y);
        System.out.println(answer);

    }

    public static void bfs(int x, int y) {
        visit = new boolean[N][M];

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y, 0});
        visit[x][y] = true;
        int Maxdist = 0;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int now_x = now[0];
            int now_y = now[1];
            int dist = now[2];

            Maxdist= Math.max(Maxdist,dist);

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if (range_chk(next_x, next_y) && !visit[next_x][next_y] && arr[next_x][next_y] > shark_Size) {
                    que.add(new int[]{next_x, next_y, dist + 1});
                    visit[next_x][next_y] = true;
                }
            }
        }
        return Maxdist;
    }

    public static boolean range_chk(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < M;
    }
}