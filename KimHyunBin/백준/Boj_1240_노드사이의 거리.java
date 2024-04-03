import java.io.*;
import java.util.*;


public class Main { //Boj_1240_노드사이의 거리
    // 상하좌우
    static int[][] arr;
    static boolean[] visit;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr[start][end] = value;
            arr[end][start] = value;
        }

        for (int i = 0; i < M; i++) {
            visit = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int answer = bfs(start, end, visit);
            System.out.println(answer);
        }
    }

    public static int bfs(int start, int end, boolean[] visit) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start, 0});
        visit[start] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int now_x = now[0];
            int dist = now[1];

            if (now_x == end) {
                return dist;
            }

            for (int i = 1; i <= N; i++) {
                if (arr[now_x][i] != 0 && !visit[i]) {
                    que.add(new int[]{i, (dist + arr[now_x][i])});
                    visit[i] = true;
                }
            }
        }
        return -1;
    }
}