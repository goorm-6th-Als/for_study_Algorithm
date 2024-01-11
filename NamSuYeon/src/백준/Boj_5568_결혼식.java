package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5568_결혼식 {
    static boolean[][] graph;
    static boolean[] isChecked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        int friendOfSize = 0;

        graph = new boolean[size+1][size+1];
        isChecked = new boolean[size+1];

        for(int i = 0; i < line; i++){
            st  = new StringTokenizer(br.readLine());
            int x  = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        for(int i = 1; i<graph[1].length; i++){
            if(graph[1][i]){
                friendOfSize++;
            }
        }
        bfs(1,friendOfSize);
        int count =0;
        for(int i = 2; i<isChecked.length; i++){
            if(isChecked[i]){
                count++;
            }
        }

        System.out.println(count);
    }

    private static void bfs(int start,int size) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int i = 0;
        while (i<size+1){
            int num = queue.poll();
            for(int j = 1; j< graph.length; j++){
                if(graph[j][num] && !isChecked[j]){
                    isChecked[j] = true;
                    queue.add(j);
                }
            }
            i++;
        }
    }
}
