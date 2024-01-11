package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj_11724_연결_요소의_개수 {
	static BufferedReader br;
	static BufferedWriter bw;
	static boolean graph[][];
	static boolean visit[];
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
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
		
		for(int i=1; i<=n;i++) {
			if(!visit[i]) {
				cnt++;
				dfs(i);
			}
		}
		bw.append(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int index) {
		if(visit[index]) return;
		visit[index] = true;
		for(int i=1; i<visit.length;i++) {
			if(graph[index][i]) dfs(i);
		}
	}
}