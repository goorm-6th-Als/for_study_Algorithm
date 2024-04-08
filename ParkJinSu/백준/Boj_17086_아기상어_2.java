package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


public class Boj_17086_아기상어_2 {
    static boolean[][] visit;
    static int[][] graph;
    static boolean[][] shark;
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        graph = new int[n][m];
        shark = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if(st.nextToken().equals("1")) shark[i][j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!shark[i][j]){
                    visit = new boolean[n][m];
//                    System.out.println("시작합니다 i = " + i +" j = " +j);
                    graph[i][j] = bfs(i,j);
                }
            }
        }
        int answer=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, graph[i][j]);
            }
        }

        bw.append(answer +"");
        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visit[y][x] = true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
//            System.out.println(" y= " + tmp[0]);
//            System.out.println(" x= " + tmp[1]);
//            visit[tmp[0]][tmp[1]] = true;
            if(shark[tmp[0]][tmp[1]]) return Math.max(Math.abs(y - tmp[0]), Math.abs(x - tmp[1]));

            for (int i = 0; i < 8; i++) {
                if(tmp[0] + dy[i] < 0 || tmp[0] + dy[i] >= n) continue;
                if(tmp[1] + dx[i] < 0 || tmp[1] + dx[i] >= m) continue;
                if(!visit[tmp[0] + dy[i]][tmp[1] + dx[i]]){
                    visit[tmp[0] + dy[i]][tmp[1] + dx[i]] = true;
                    q.add(new int[] {(tmp[0] + dy[i]), (tmp[1] + dx[i])});
                }
            }
        }

        return 0;
    }




}
