package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1303_전쟁 {
    static String[][] graph;
    static boolean[][] isChecked;
    static int xMove[] = new int[]{1, 0, -1, 0};
    static int yMove[] = new int[]{0, 1, 0, -1};
    static int WCount = 0;
    static int BCount = 0;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new String[x][y];
        isChecked = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            graph[i] = br.readLine().split("");
        }

        //System.out.println("입력 완료");

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!isChecked[i][j]) {
                    bfs(i, j,graph[i][j]);
                }
            }
        }

        System.out.println(WCount+" "+BCount);
    }

    private static void bfs(int x, int y, String value) {
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        isChecked[x][y] = true;

        while (!queue.isEmpty()) {
            Node remove = queue.poll();
            //isChecked[remove.x][remove.y] = true;
            count++;
            for (int i = 0; i < 4; i++) {
                if (0 <= remove.x + xMove[i] && remove.x + xMove[i] < graph.length && 0 <= remove.y + yMove[i] && remove.y + yMove[i] < graph[0].length && !isChecked[remove.x + xMove[i]][remove.y + yMove[i]]){
                    if (graph[remove.x + xMove[i]][remove.y + yMove[i]].equals(value) ){
                        isChecked[remove.x + xMove[i]][remove.y + yMove[i]] = true;
                        queue.add(new Node(remove.x + xMove[i],remove.y + yMove[i]));
                    }
                }
            }
        }

        System.out.println(value+" 부분 :" +count);
        if(value.equals("W")){
            WCount += count * count;
        } else if (value.equals("B")) {
            BCount += count *count;
        }
    }
}
