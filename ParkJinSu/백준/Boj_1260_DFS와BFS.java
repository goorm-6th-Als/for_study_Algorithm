package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


public class Boj_1260_DFS와BFS {
    static boolean[] visit;
    static int answer=0;
    static boolean[][] graph;
    static int n,m,v;

    static BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        v = parseInt(st.nextToken());
        graph = new boolean[n+1][n+1];
        visit = new boolean[n+1];
        int num1, num2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            num1 = parseInt(st.nextToken());
            num2 = parseInt(st.nextToken());
            graph[num1][num2] = true;
            graph[num2][num1] = true;
        }
        visit[v]  = true;
        dfs(v);
        bw1.append("\n");
        visit = new boolean[n+1];
        visit[v]  = true;
        bfs(v);
        bw1.flush();
        bw1.close();
        //bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()){
            int tmp = q.poll();
            bw1.append(tmp+" ");
            for (int i = 1; i <= n; i++) {
                if(graph[tmp][i] && !visit[i]){
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }

    static  void dfs(int start) throws IOException {
        bw1.append(start+" ");
        for (int i = 1; i <= n; i++) {
            if(graph[start][i] && !visit[i]){
                visit[i] =true;
                dfs(i);
            }
        }
    }

}
