import java.io.*;
import java.util.*;

public class Main { // Boj_2660_회장뽑기
    static int N;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1][N + 1];

        // Input processing
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n_1 = Integer.parseInt(st.nextToken());
            int n_2 = Integer.parseInt(st.nextToken());
            if (n_1 == -1 && n_2 == -1) {
                break;
            }
            arr[n_1][n_2] = true;
            arr[n_2][n_1] = true;
        }

        int min = Integer.MAX_VALUE;
        List<int[]> list = new ArrayList<>(); // 회장 점수 정리
        for (int i = 1; i <= N; i++) {
            int depth = bfs(i);
            list.add(new int[]{i, depth});
            min = Math.min(min, depth);
        }

        List<Integer> answer = new ArrayList<>(); // 회장후보
        for (int[] result : list) {
            if (result[1] == min) {
                answer.add(result[0]);
            }
        }
        Collections.sort(answer);
        sb.append(min).append(" ").append(answer.size()).append("\n");
        for (int n : answer) {
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start, 0});
        visited[start] = true;
        int maxDepth = 0;

        while (!que.isEmpty()) {
            int[] current = que.poll();
            int node = current[0];
            int depth = current[1];
            maxDepth = Math.max(maxDepth, depth);
            for (int i = 1; i <= N; i++) {
                if (arr[node][i] && !visited[i]) {
                    visited[i] = true;
                    que.add(new int[]{i, depth + 1});
                }
            }
        }
        return maxDepth;
    }
}