package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 코테1회차_1번 {
    //1260번 DFS와 BFS
    static boolean[][] graph;
    static boolean isChecked[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pointSize = Integer.parseInt(st.nextToken());
        graph = new boolean[pointSize+1][pointSize+1];
        isChecked = new boolean[pointSize+1];
        int lineSize = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(st.nextToken());

        for(int i = 0; i<lineSize; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = true;
            graph[end][start] = true;
        }

        System.out.println(DFS(startPoint));
        isChecked = new boolean[pointSize+1];
        System.out.println(BFS(startPoint));


    }

    private static String BFS(int startPoint) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startPoint);
        isChecked[startPoint] = true;
        StringBuilder result = new StringBuilder();

        while(!queue.isEmpty()){
            int number = queue.poll();
            result.append(number).append(" ");
            for(int i = 0; i<graph[number].length; i++){
                if(graph[number][i] && !isChecked[i]){
                    isChecked[i] = true;
                    queue.add(i);
                }
            }
        }
        return result.toString();
    }

    private static String DFS(int startPoint) {
        String result = "";
        isChecked[startPoint] = true;
        result += startPoint + " ";
        for (int i = 0; i < graph[startPoint].length; i++) {
            if (graph[startPoint][i] && !isChecked[i]) {
                System.out.println("result: " + result);
                result += DFS(i);
            }
        }
        return result;
    }
}
