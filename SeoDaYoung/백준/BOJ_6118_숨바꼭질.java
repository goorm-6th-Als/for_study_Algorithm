import java.io.*;
import java.util.*;

public class BOJ_6118_숨바꼭질 {
    static int N, M;
    static ArrayList<Integer> arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            arr[s1].add(s2); // 양방향 그래프 구성
            arr[s2].add(s1);
        }
        bfs(1); // 1번 헛간부터 탐색
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        int[] cnt = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        int max = 0;
        int index = 0; // 숨어야 하는 헛간까지의 거리
        int max_cnt = 0; // 같은 거리를 갖는 헛간의 개수

        // 시작점 추가 후 방문 처리
        q.offer(x);
        visited[x] = true;

        // 노드를 순차적으로 꺼내 탐색
        while (!q.isEmpty()) {
            x = q.poll();

            // 현재 헛간에서 갈 수 있는 모든 헛간에 대해
            for (int idx : arr[x]) {
                if (!visited[idx]) {
                    q.offer(idx);
                    visited[idx] = true;

                    // 이전 헛간까지의 거리 + 1을 현재 헛간 거리로 설정
                    cnt[idx] = cnt[x] + 1;
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            if (cnt[i] > max) { // 가장 먼 헛간
                max = cnt[i];
                index = i;
                max_cnt = 1;
            } else if (max == cnt[i]) { // 같은 거리를 가진 헛간
                max_cnt++;
            }
        }
        System.out.println(index + " " + cnt[index] + " " + max_cnt);
    }
}
