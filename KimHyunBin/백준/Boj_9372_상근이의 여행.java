import java.io.*;
import java.util.*;

class Main { // Boj_9372_상근이의 여행_S4
	public static boolean[][] map;
	public static boolean[] visit;
	public static int N, M, answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int Tc = 1; Tc <= T; Tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new boolean[N + 1][N + 1];
			visit = new boolean[N + 1];
			// input -------------------------------
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
			}
			// -------------------------------------

			System.out.println(N - 1);
		}
	}
}

//    public static void bfs(int start) {
//        Queue<Integer> que = new LinkedList<>();
//        que.add(start);
//        while(!que.isEmpty()) {
//            int now = que.poll();
//            for(int i = 1; i<= N; i++){
//                if(map[now][i] == true && now != i && !visit[i]){
//                    que.add(i);
//                    visit[i] = true;
//                    answer++;
//                }
//            }
//        }
//    }
//}