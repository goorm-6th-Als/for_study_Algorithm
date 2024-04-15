import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static char[][] map;
    static boolean[][] isVisited;

    static List<Integer> cntW = new ArrayList<>();
    static List<Integer> cntB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        map = new char[M][N];
        isVisited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    if (map[i][j] == 'W') {
                        cntW.add(dfs(i, j, 'W'));
                    } else if (map[i][j] == 'B') {
                        cntB.add(dfs(i, j, 'B'));
                    }
                }
            }
        }

        int W = cntW.stream().mapToInt(i -> i * i).sum();
        int B = cntB.stream().mapToInt(i -> i * i).sum();

        System.out.print(W + " " + B);
    }

    static int dfs(int x, int y, char WorB) {
        isVisited[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            // 범위 안이고, 방문하지 않았으면서 같은 색의 병사인 경우
            if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && !isVisited[nextX][nextY] &&
                    map[nextX][nextY] == WorB) {
                count += dfs(nextX, nextY, WorB);
            }
        }
        return count;
    }
}