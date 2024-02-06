package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1189_컴백홈 {
    static String[][] map;
    static boolean[][] isChecked;
    static int K;
    static int size = 0;

    static int[] xMove = {0, -1, 0, -1};
    static int[] yMove = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isChecked = new boolean[R][C];

        map = new String[R][C];

        for(int i = 0; i<R; i++){
            String[] split = br.readLine().split("");
            map[i] = split;
        }

        dfs(R-1,0,0);
        System.out.println(size);

    }

    private static void dfs(int x, int y, int deap) {
        isChecked[x][y] = true;
        if(x == 0 && y == isChecked[x].length-1){
            size++;
            return ;
        }
        if(deap > K ){
            return ;
        }
        for(int i = 0; i<4; i++){
            if(0 <=x+xMove[i] && x+xMove[i] < isChecked.length && 0<y+yMove[i] && y+yMove[i] < isChecked[x].length){
                if (!isChecked[x+xMove[i]][y+yMove[i]] && map[x+xMove[i]][y+yMove[i]].equals(".")){
                    dfs(x+xMove[i],y+yMove[i],deap + 1);
                    isChecked[x+xMove[i]][y+yMove[i]] = false;
                }
            }
        }
    }
}
