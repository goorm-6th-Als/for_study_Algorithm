package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


public class Boj_31575_도시와_비트코인 {
    static boolean[][] visit;
    static int dx[] = {0,1};
    static int dy[] = {1,0};
    static boolean[][] graph;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());

        graph = new boolean[m][n];
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("1")){
                    graph[i][j] = true;
                }
            }
        }
        bw.append(bfs());
        bw.flush();
        bw.close();
        br.close();

    }

    static String bfs(){
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0,0});
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0] == m-1 && tmp[1] == n-1) return "Yes";
            for (int i = 0; i < 2; i++) {
                int y = tmp[0] + dy[i];
                int x = tmp[1] + dx[i];
                if(check(x, y)){
                    visit[y][x] = true;
                    q.add(new int[]{y,x});
                }
            }
        }
        return "No";
    }

    static boolean check(int x, int y){
        if(x>=n || m <= y || visit[y][x] || !graph[y][x]) return false;
        return true;
    }

}
