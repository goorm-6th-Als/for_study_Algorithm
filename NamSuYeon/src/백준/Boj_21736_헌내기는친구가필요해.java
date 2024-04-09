package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_21736_헌내기는친구가필요해 {

    static int[] xMove = new int[]{1, 0, -1, 0};
    static int[] yMove = new int[]{0, 1, 0, -1};
    static String[][] map;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map = new String[x][y];
        visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j].equals("I")) {
                    dfs(i, j);
                    break;
                }
            }
        }
        if(count != 0){
            System.out.println(count);
        }else {
            System.out.println("TT");
        }

    }

    private static void dfs(int i, int j) {

        if (map[i][j].equals("P")) {
            visited[i][j] = true;
            count++;
        }
        if (map[i][j].equals("X")) {
            return;
        }

        for (int z = 0; z < 4; z++) {
            if (0 <= (i + xMove[z]) && (i + xMove[z]) < map.length && 0 <= (j + yMove[z]) && (j + yMove[z]) < map[0].length && !visited[i + xMove[z]][j + yMove[z]]) {
                visited[i][j] = true;
                dfs(i+xMove[z],j+yMove[z]);
            }
        }
    }
}
