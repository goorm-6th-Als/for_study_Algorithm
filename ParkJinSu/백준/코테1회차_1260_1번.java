package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 코테1회차_1260_1번 {//1260 DFS와 BFS _1번

	static boolean[][] graph;
	static boolean[] visit;
	static Queue<Integer> q = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		int start =Integer.parseInt(st.nextToken());
		int left,right;
		graph = new boolean[n+1][n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			left = Integer.parseInt(st.nextToken());
			right = Integer.parseInt(st.nextToken());
			
			graph[left][right] = true;
			graph[right][left] = true;
			
		}
		visit = new boolean[n+1];
		dfs(start);
		sb.append("\n");
		visit = new boolean[n+1];
		bfs(start);
		bw.append(sb);
		bw.close();
		br.close();
	}
	
	static void dfs(int start) {
		visit[start] = true;
		sb.append(start+" ");
		for(int i=1;i<visit.length;i++) {
			if(graph[start][i] && !visit[i]) {
				dfs(i);
			}
		}
	}
	static void bfs(int start) {
		q.add(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			start = q.poll();
			sb.append(start+" ");
			for(int i=1; i<visit.length; i++) {
				if(graph[start][i] && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}

}
