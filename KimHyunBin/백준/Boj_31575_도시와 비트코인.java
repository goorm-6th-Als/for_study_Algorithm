import java.io.*;
import java.util.*;

public class Main { // Boj_31575_도시와 비트코인
    static int N;
    static int M;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static boolean[][] visit;
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        visit = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit[0][0] = true;
        String answer = (dfs(0, 0)) ? "Yes" : "No";
        System.out.println(answer);
    }

    public static boolean dfs(int r, int c) {
        if (r == M - 1 && c == N - 1) {
            return true;
        }
        for (int i = 0; i < 2; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < M && nc < N){
                if(!visit[nr][nc] && arr[nr][nc] != 0){
                    visit[nr][nc] = true;
                    if (dfs(nr, nc)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}