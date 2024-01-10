import java.util.*;
import java.io.*;

public class Main { // 1260_DFS와BFS
	static int answer,node,edge;
	static Queue<Integer> que = new LinkedList<>();
	static boolean[] chk;
	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		map = new int[node+1][node+1];
		chk = new boolean[node+1];
		
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = map[b][a] = 1;
	    }
		dfs(start);
		sb.append('\n');
		chk = new boolean[node+1];
		bfs(start);
		
		System.out.println(sb);
	}
//
	public static void dfs(int start) {
		chk[start] = true;
		sb.append(start + " ");
		
		for(int i = 0; i<= node; i++) {
			if(map[start][i] == 1 && !chk[i]) {
				dfs(i);
			}
		}
	}
	//

	public static void bfs(int start) {
		que.add(start);
		chk[start] = true;
		
		while(!que.isEmpty()) {
			start = que.poll();
			sb.append(start+" ");
			
			for(int i = 0; i<= node; i++) {
				if(map[start][i] == 1 && !chk[i]) {
					que.add(i);
					chk[i] = true;
				}
			}
		}
	}
}
