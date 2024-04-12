import java.io.*;
import java.util.*;

public class BOJ_1260_DFS와_BFS {
    static int N, M, V;
    static ArrayList<Integer>[] arr; // 인접 리스트
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }
        DFS(V);
        // 방문 배열 초기화 후 줄바꿈
        visited = new boolean[N + 1];
        sb.append("\n");
        BFS(V);
        System.out.println(sb);
    }

    public static void DFS(int index) {
        visited[index] = true;
        sb.append(index + " ");

        for (int i : arr[index]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int index) {
        visited[index] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(index);

        while (!q.isEmpty()) {
            int a = q.poll(); // 하나의 노드를 뽑아 방문 처리
            sb.append(a + " ");

            for (int i : arr[a]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}