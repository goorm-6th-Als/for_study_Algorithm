import java.io.*;
import java.util.*;

class Node {
    int now, dist;
    Node(int now, int dist) {
        this.now = now;
        this.dist = dist;
    }
}

public class Main {
    static List<List<Node>> tree;
    static boolean[] visit;
    static int N;
    static int max;
    static int far_Node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree.get(start).add(new Node(end, weight));
            tree.get(end).add(new Node(start, weight));
        }
        // 가장 먼 노드 찾기.
        visit = new boolean[N + 1];
        dfs(1, 0);

        visit = new boolean[N + 1];
        dfs(far_Node, 0);

        System.out.println(max);
    }

    public static void dfs(int node, int value) {
        visit[node] = true;

        if (value > max) { // 합이 더 크다면 멀다고 판단.
            max = value;
            far_Node = node;
        }

        for (Node next : tree.get(node)) {
            if (!visit[next.now]) {
                dfs(next.now, value + next.dist);
            }
        }
    }
}