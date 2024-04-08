import java.io.*;
import java.util.*;

public class Solution { // Prg_가장 먼 노드
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] arr = new boolean[n + 1][n + 1];
        int [] visit = new int[n + 1];

        for (int i = 0; i < edge.length; i++) {
            for (int j = 0; j < edge[i].length; j++) {
                int start = edge[i][0];
                int end = edge[i][1];
                arr[start][end] = true;
                arr[end][start] = true;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visit[1] = 1;
        int distance = 0;
        while (!que.isEmpty()) {
            int now = que.poll();

            for (int i = 0; i <= n; i++) {
                if (visit[i] != 0 || !arr[now][i])
                    continue;
                que.add(i);
                visit[i] = visit[now] + 1;
                distance = visit[i];
            }
        }
//        System.out.println("distance = " + distance);
//        for(int i = 1; i<=n; i++){
//            int s = visit[i];
//            System.out.println(i+" visit = " + s);
//        }

        for(int i =0; i<visit.length; i++){
           if(distance == visit[i]){
               answer ++;
           }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 6;
        int [][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};

        System.out.println(solution(N,vertex));


    }
}