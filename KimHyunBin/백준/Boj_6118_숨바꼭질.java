import java.io.*;
import java.util.*;

public class Main { // Boj_6118_숨바꼭질
    static int N;
    static int M;
    static int max_Dist;

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        bfs(1);

        for (int key : map.keySet()) {
            if (map.get(key) == max_Dist) {
                list.add(key);
            }
        }
        Collections.sort(list);

        int answer_Num = list.get(0);
        int answer_dist = max_Dist;
        int answer_cnt = list.size();
        System.out.println(answer_Num + " " + answer_dist + " " + answer_cnt);

    }

    public static void bfs(int start) {
        visit = new boolean[N + 1];

        Queue<int []> que = new LinkedList<>();
        que.add(new int [] {start, 0});
        visit[start] = true;

        while (!que.isEmpty()) {
            int [] now = que.poll();
            int idx = now[0];
            int dist = now[1];
            map.put(idx, dist);
            max_Dist = Math.max(max_Dist, dist);
            for (int neighbor : graph.get(idx)) {
                if (!visit[neighbor]) {
                    visit[neighbor] = true;
                    que.offer(new int[]{neighbor, dist + 1});
                }
            }
        }
    }
}