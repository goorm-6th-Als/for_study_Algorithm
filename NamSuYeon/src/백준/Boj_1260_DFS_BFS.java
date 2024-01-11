package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_1260_DFS_BFS {

    static int[][] graph;
    static boolean[] isChecked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // dfs(너비 우선 탑색) bfs(깊이 우선 탐색)

        graph = new int[Integer.parseInt(input[0])+1][Integer.parseInt(input[0])+1];
        isChecked = new boolean[Integer.parseInt(input[0])+1];

        for(int i = 0; i < Integer.parseInt(input[1]); i++){
            String[] read = br.readLine().split(" ");
            int a = Integer.parseInt(read[0]);
            int b = Integer.parseInt(read[1]);

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        String dfsResult = DFS(Integer.parseInt(input[2]));

        isChecked = new boolean[Integer.parseInt(input[0])+1];
        String bfsResult = BFS(Integer.parseInt(input[2]));

        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }

    private static String BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()){
            int num = queue.poll();
            result.append(num).append(" ");
            isChecked[num] = true;
            for(int i = 1; i<graph[num].length; i++){
                if(graph[num][i] == 1 && !isChecked[i]){
                    isChecked[i] = true;
                    queue.add(i);
                }
            }
        }
        return result.toString();
    }

    private static String DFS(int start) {

        StringBuilder st = new StringBuilder();
        st.append(start).append(" ");
        isChecked[start] = true;
        for(int i = 1; i<graph[start].length; i++){
            if(graph[start][i] == 1 && !isChecked[i]){
                st.append(DFS(i));
            }
        }
        return st.toString();
    }
}
