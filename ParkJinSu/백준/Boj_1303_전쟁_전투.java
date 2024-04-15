package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Boj_1303_전쟁_전투 {
        static  int[] dx = {1,-1,0,0};
        static  int[] dy = {0,0,1,-1};
        static long W=0;
        static long B=0;
        static boolean[][] visit;
        static boolean[][] graph;
        static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());//가로
        m = parseInt(st.nextToken());//세로
        visit = new boolean[m][n];
        graph = new boolean[m][n]; // 나true == W  적false == B
        String tmp;
        for (int i = 0; i < m; i++) {
            tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                if(tmp.charAt(j) == 'W') graph[i][j] =true;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]){
                    bfs(i,j, graph[i][j]);
                }
            }
        }
        bw.append(W +" " + B);
        bw.close();
        br.close();
    }

    static void bfs(int i, int j, boolean filter){
        Queue<int[]> q= new LinkedList();
        q.add(new int[] {i,j});
        int cnt=1;
        visit[i][j]= true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[1];
            int y = tmp[0];
            for (int k = 0; k < 4; k++) {
                int nowY = y + dy[k];
                int nowX = x + dx[k];
                if(check(nowX, nowY) && graph[nowY][nowX] == filter) {
                    cnt++;
                    visit[nowY][nowX] = true;
                    q.add(new int[] {nowY, nowX});
                }

            }
        }


        if(filter) W += cnt*cnt;
        else B += cnt*cnt;
    }

    static boolean check(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m || visit[y][x]) return false;
        return true;
    }

}