import java.io.*;
import java.util.*;

public class Main { // Boj_12852_1로 만들기 2
	public static int N, answer;
	public static int [] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp = new int[N+1];
		Arrays.fill(dp, -1);
		bfs();
		printPath(); // 경로 출력	
	}
	public static void bfs () {
		Queue <Integer> que = new LinkedList<>();
		que.add(N);
		dp[N] = 0;
		while(!que.isEmpty()) {
			int q_size = que.size();
			
			for(int i = 0; i<q_size; i++) {
				int num = que.poll();
				if(num == 1) {
					return;
				}
				 // 다음 숫자 확인 및 배열 업데이트
	            if (num % 3 == 0 && dp[num / 3] == -1) {
	                que.add(num / 3);
	                dp[num / 3] = num;
	            }
	            if (num % 2 == 0 && dp[num / 2] == -1) {
	                que.add(num / 2);
	                dp[num / 2] = num;
	            }
	            if (num > 1 && dp[num - 1] == -1) {
	                que.add(num - 1);
	                dp[num - 1] = num; 
	            }
			}
			answer ++;
		}
		return;
	}
	// 경로를 역추적하여 출력하는 메소드
    private static void printPath() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i != 0; i = dp[i]) {
            sb.insert(0, i + " ");
        }
        sb.insert(0, answer + "\n");
        System.out.println(sb);
    }
}
