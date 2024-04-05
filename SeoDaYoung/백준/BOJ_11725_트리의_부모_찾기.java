import java.io.*;
import java.util.*;

public class BOJ_11725_트리의_부모_찾기 {
    static StringTokenizer st;
    static int n;
    static int[] parent;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1]; // 부모 노드 저장
        list = new ArrayList[n + 1]; // 노드 저장
        visited = new boolean[n + 1]; // 방문 여부 확인

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int index) {
        visited[index] = true;

        // 방문하지 않은 노드를 만나면 현재 노드(index)를 부모로 설정
        for (int i : list[index]) {
            if (!visited[i]) {
                parent[i] = index;
                dfs(i);
            }
        }
    }
}
