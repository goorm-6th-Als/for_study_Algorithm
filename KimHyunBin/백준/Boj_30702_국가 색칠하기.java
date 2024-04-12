import java.io.*;
import java.util.*;

public class Main { //Boj_30702_국가 색칠하기
    static int N, M;
    static char[][] A,B ;
    static boolean[][] visit_A, visit_B;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static boolean answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[N][M];
        B = new char[N][M];
        visit_A = new boolean[N][M];
        visit_B = new boolean[N][M];
        answer = true;
        for (int i = 0; i < N; i++) {
             String str = (br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            String str = (br.readLine());
            for (int j = 0; j < M; j++) {
                B[i][j] = str.charAt(j);
            }
        }
        Loop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit_A[i][j]) {
                    bfs(A, visit_A, i, j);
                }
                if (!visit_B[i][j]) {
                    bfs1(B, visit_B, i, j);
                }
                if (!compare()) { // A랑 B 동시 체크
                    answer = false;
                    break Loop;
                }
            }
        }

        System.out.println(answer ? "YES" : "NO");
    }

    private static void bfs(char[][] arr, boolean[][] visited, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nR = now[0] + dr[i];
                int nC = now[1] + dc[i];
                if (nR >= 0 && nR < N && nC >= 0 && nC < M && !visited[nR][nC] && arr[now[0]][now[1]] == arr[nR][nC]) {
                    visited[nR][nC] = true;
                    queue.offer(new int[]{nR, nC});
                }
            }
        }
    }
    private static void bfs1(char[][] arr, boolean[][] visited, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nR = now[0] + dr[i];
                int nC = now[1] + dc[i];
                if (nR >= 0 && nR < N && nC >= 0 && nC < M && !visited[nR][nC] && arr[now[0]][now[1]] == arr[nR][nC] && visit_A[nR][nC]) {
                    visited[nR][nC] = true;
                    queue.offer(new int[]{nR, nC});
                }
            }
        }
    }

    private static boolean compare() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit_A[i][j] != visit_B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}