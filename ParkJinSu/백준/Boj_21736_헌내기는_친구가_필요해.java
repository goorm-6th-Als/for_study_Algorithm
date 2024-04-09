package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


public class Boj_21736_헌내기는_친구가_필요해 {
    static boolean[][] visit;
    static int answer=0;
    static char[][] campus;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());

        visit = new boolean[n][m];
        campus = new char[n][m];
        for (int i = 0; i < n; i++) {
            campus[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(campus[i][j] == 'I'){
                    visit[i][j] = true;
                    dfs(i, j);
                    if (answer ==0) bw.append("TT");
                    else bw.append(answer +"");
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
            }
        }
        bw.append(answer +"");
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int y, int x){
        int nowX;
        int nowY;
        for (int i = 0; i < 4; i++) {
            nowY = y + dy[i];
            nowX = x + dx[i];
            if(check(nowY, nowX)){
                visit[nowY][nowX] = true;
                dfs(nowY, nowX);
            }
        }
    }

    static boolean check(int y, int x){
        if(y < 0 || x < 0 || y>= n || x >= m || campus[y][x] == 'X'|| visit[y][x]) return false;
        if(campus[y][x] == 'P') answer++;
        return true;
    }


}
