package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj_5567_결혼식 {
	static BufferedReader br;
	static BufferedWriter bw;
	static boolean graph[][];
	static boolean visit[];
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int a,b,cnt=0;
		graph= new boolean[n+1][n+1];
		visit = new boolean[n+1];
		for(int i=0; i<m; i++) {
			st= new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		for(int i=2; i<n+1; i++) {
			
			if(graph[1][i]) {
				
				for(int j=2;j<n+1;j++) {
					if(graph[i][j] && graph[1][j]) {
						graph[i][j] = false;
						graph[j][i] = false;
					}
				}
			}
				
		}
		dfs(1,3);
		for(int i=2; i<=n; i++) {
			if(visit[i]) {
				cnt++;
			}
			
		}
		bw.append(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int index, int d) {
		if(visit[index] || d==0) return;
		int deep=d-1;
		visit[index] = true;
		for(int i=1; i<visit.length;i++) {
			if(graph[index][i]) {
				dfs(i, deep);
			}
			
		}
	}
}