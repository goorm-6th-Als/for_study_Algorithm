import java.util.*;
import java.io.*;

public class Main { //Boj_2775_부녀회장이될테야
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// a층의 b호라면 a-1의 1~b호의 사람의 수 합 만큼 사람이 있다면 k층 n호엔 몇명?
		
		int T = Integer.parseInt(st.nextToken());
		int dp [][] = new int [15][15];
		// 0층 값 넣어주기.
		for(int i = 1; i<15; i++) {
			dp[0][i] = i;
		}
		// 1호 값 넣어주기
		for(int i = 1; i<15; i++) {
			dp[i][1] = dp[i-1][1];
		}
		for(int tc = 1; tc <= T; tc++ ) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int arr [][] = new int [k][n];
			
			for(int i = 1; i<=k; i++) {
				for(int j = 2; j<=n; j++) {
					// dp[2][1] = dp[1][1]
					// dp[2][2] = dp[2][1]+dp[1][2]
					// dp[2][3] = dp[2][2]+dp[1][3]
					dp[i][j] = dp[i][j-1] + dp[i-1][j];
				}
			}
			
			System.out.println(dp[k][n]);
		}
	}
}
