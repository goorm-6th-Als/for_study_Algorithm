package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


public class Boj_30702_국기_색칠하기 {
    static boolean[][] visit;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static char[][] graph1;
    static char[][] graph2;
    static int n,m;
    static boolean go = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());

        graph1 = new char[n][m];
        graph2 = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            graph1[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            graph2[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visit[i][j] == false){
                    bfs(graph1[i][j], graph2[i][j],i,j);
                    if (!go){
                        bw.append("NO");
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    }
                }
            }
        }
        bw.append("YES");
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(char g1, char g2, int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nowY = tmp[0] + dy[i];
                int nowX = tmp[1] + dx[i];
                if(check(nowY, nowX, g1)){
                    visit[nowY][nowX] = true;
                    if(graph2[nowY][nowX] != g2){
                        go = false;
                        return;
                    }
                    q.add(new int[] {nowY, nowX});
                }
            }
        }
    }

    static boolean check(int y, int x, char g1){
        if(x < 0|| y < 0||y>=n || x>=m || visit[y][x] || graph1[y][x] != g1) return false;
        return true;
    }

}
