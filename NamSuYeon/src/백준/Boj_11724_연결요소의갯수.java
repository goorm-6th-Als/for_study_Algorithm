package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11724_연결요소의갯수 {
    static boolean [][]graph;
    static boolean [] isChecked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int point = Integer.parseInt(str[0]);
        int line = Integer.parseInt(str[1]);
        int count = 0;
        graph = new boolean[point+1][point+1];
        isChecked = new boolean[point+1];

        for(int i = 1; i<line+1; i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            graph[x][y] = true;
            graph[y][x] = true;
        }

        for(int i = 1; i<isChecked.length; i++){
            if(!isChecked[i]){
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    private static void DFS(int start) {
        isChecked[start] = true;
        for(int i = 1; i<graph.length; i++){
            if(graph[start][i] && !isChecked[i]){
                DFS(i);
            }
        }
    }
}
