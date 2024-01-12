import java.util.*;
import java.io.*;

public class Main {// Boj_5567_결혼식
	static int N, M, answer;
	static boolean arr[][];
	static boolean visit[];
	static int friend[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = 0;
		N = Integer.parseInt(st.nextToken()); // 동기 수
		M = Integer.parseInt(br.readLine());
		arr = new boolean[N + 1][N + 1]; // 친구관계
		friend = new int[N + 1]; // 관계
		visit = new boolean[N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = true;
			arr[b][a] = true;
		}

		Queue<Integer> que = new LinkedList<>();

		que.add(1);
		answer =0;
		friend[1] = 0;
		while (!que.isEmpty()) {
			int num = que.poll();
			for (int i = 2; i <= N; i++) {
				if (arr[num][i] && !visit[i]) {
					visit[i] = true;
					friend[i] = friend[num] + 1;
					answer++;
					if(friend[i] == 2) {
						continue;
					}
					que.add(i);	
				}
			}

		}

		System.out.println(answer);
	}
}