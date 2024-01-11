import java.util.*;
import java.io.*;

public class Main {// Boj_11724_연결요소의개수
	static int N, M, answer;
	static boolean arr[][];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // node
		M = Integer.parseInt(st.nextToken()); // edge
		arr = new boolean[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = true;
			arr[b][a] = true;
		}
		visit[1] = true;
		dfs(1);
		answer = 1;

		for (int i = 2; i <= N; i++) {
			if (visit[i])
				continue;
			System.out.println(i);
			visit[i] = true;
			answer += 1;
			dfs(i);
		}

		System.out.println(answer);
	}

	public static void dfs(int start) {

		for (int i = 2; i <= N; i++) {
			if (arr[start][i] == false)
				continue;
			if(visit[i])
				continue;
			visit[i] = true;
			dfs(i);
		}
	}
}