import java.io.*;
import java.util.*;

public class Main { //Boj_1303_전쟁-전투
    static int N, M, power_W, power_B;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken()); // col
        M = Integer.parseInt(st.nextToken()); // row
        arr = new char[M][N];
        visit = new boolean[M][N];
        //input
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) {
                    continue;
                }
                if (arr[i][j] == 'W') {
                    power_W += Bfs(i, j, true);
                } else {
                    power_B += Bfs(i, j, false);
                }
            }
        }
        System.out.print(power_W + " ");
        System.out.print(power_B);
    }

    public static int Bfs(int row, int col, boolean me) {
        int size = 1;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row, col});
        visit[row][col] = true;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int n_row = now[0] + dr[i];
                int n_col = now[1] + dc[i];
                if (range_chk(n_row, n_col) && !visit[n_row][n_col]) {
                    if ((me && arr[n_row][n_col] == 'W') || (!me && arr[n_row][n_col] == 'B')) {
                        que.add(new int[]{n_row, n_col});
                        visit[n_row][n_col] = true;
                        size++;
                    }
                }
            }
        }
//        System.out.println("me = " + me);
//        System.out.println("size = " + size);
        return size * size;
    }

    public static boolean range_chk(int row, int col) {
        return row >= 0 && col >= 0 && row < M && col < N;
    }
}